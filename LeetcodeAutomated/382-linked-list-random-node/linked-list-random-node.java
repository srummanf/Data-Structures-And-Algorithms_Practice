import java.util.Random;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    private ListNode head;
    private Random rand;

    public Solution(ListNode head) {
        this.head = head;
        this.rand = new Random();
    }

    public int getRandom() {
        ListNode current = head;
        ListNode result = head;
        int count = 1;  // We start counting from 1

        while (current != null) {
            // Randomly decide whether to replace the current result
            if (rand.nextInt(count) == 0) {
                result = current;
            }
            current = current.next;
            count++;
        }

        return result.val;
    }
}
