/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode insert(ListNode head, int val) {
        ListNode newNode = new ListNode(val);
        if (head == null) {
            head = newNode;
            return head;
        }
        ListNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        newNode.next = null;
        return head;
    }

    public ListNode reverseBetween(ListNode head, int l, int r) {
        LinkedList<Integer> ll = new LinkedList<>();
        ArrayList<Integer> rev = new ArrayList<>();
        ListNode temp = head;
        while (temp != null) {
            ll.add(temp.val);
            temp = temp.next;
        }
        ListNode dummyHead = new ListNode(); // Dummy node to simplify list creation
        ListNode temp2 = dummyHead;
        int n = ll.size();
        for (int i = 0; i < n; i++) {
            if ((i >= l - 1) && (i <= r - 1)) {
                rev.add(ll.get(i));
            }
        }
        Collections.reverse(rev);
        int idx = 0;
        for (int i = 0; i < n; i++) {
            if (i < l - 1) {
                insert(temp2, ll.get(i));
            } else if ((i >= l - 1) && (i <= r - 1)) {
                insert(temp2, rev.get(idx++));
            } else {
                insert(temp2, ll.get(i));
            }
        }

        return temp2.next;

    }
}