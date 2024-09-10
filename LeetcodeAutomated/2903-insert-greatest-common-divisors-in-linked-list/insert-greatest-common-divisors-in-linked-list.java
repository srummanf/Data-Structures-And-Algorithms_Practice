class Solution {
    public int gcd(int a, int b) {
        if (b == 0)
            return a;
        else
            return gcd(b, a % b);
    }

    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode curr = head;

        while (curr != null && curr.next != null) {
            int a = curr.val;
            int b = curr.next.val;
            int gcd_val = gcd(a, b);

            // Create a new node with the GCD value
            ListNode gcdNode = new ListNode(gcd_val);

            // Insert this new node between curr and curr.next
            gcdNode.next = curr.next;
            curr.next = gcdNode;

            // Move to the next pair
            curr = gcdNode.next;
        }

        return head;
    }
}


// class Solution {
//     public int gcd(int a, int b) {
//         if (b == 0)
//             return a;
//         else
//             return gcd(b, a % b);
//     }

//     public ListNode insert(int val, ListNode root) {
//         if (root == null)
//             return new ListNode(val);
//         ListNode curr = root;
//         while (curr.next != null) {
//             curr = curr.next;
//         }
//         curr.next = new ListNode(val);
//         return root;
//     }

//     public ListNode insertGreatestCommonDivisors(ListNode head) {
//         if (head == null || head.next == null) {
//             return head;
//         }

//         ListNode curr = head;
//         ListNode ans = null;

//         while (curr.next != null) {
//             int a = curr.val;
//             int b = curr.next.val;
//             int gcd_val = gcd(a, b);

//             ans = insert(a, ans);        
//             ans = insert(gcd_val, ans);  

//             curr = curr.next;            
//         }

//         ans = insert(curr.val, ans);    

//         return ans;
//     }
// }
