class Solution {
    public int gcd(int a, int b) {
        if (b == 0)
            return a;
        else
            return gcd(b, a % b);
    }

    public ListNode insert(int val, ListNode root) {
        if (root == null)
            return new ListNode(val);
        ListNode curr = root;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = new ListNode(val);
        return root;
    }

    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode curr = head;
        ListNode ans = null;

        while (curr != null && curr.next != null) {
            int a = curr.val;
            int b = curr.next.val;
            int gcd_val = gcd(a, b);

            ans = insert(a, ans);        // Insert first value
            ans = insert(gcd_val, ans);  // Insert GCD value

            curr = curr.next;            // Move to the next node
        }

        // The loop only inserts the value before the last value is processed
        ans = insert(curr.val, ans);     // Insert the last node value

        return ans;
    }
}
