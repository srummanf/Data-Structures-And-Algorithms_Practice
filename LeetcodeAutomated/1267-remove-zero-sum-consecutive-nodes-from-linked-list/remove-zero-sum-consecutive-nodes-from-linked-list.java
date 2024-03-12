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
    public ListNode removeZeroSumSublists(ListNode head) {
        // Dummy node to serve as a new starting point for the linked list
        ListNode dummyHead = new ListNode(0, head);
        // HashMap to store the cumulative sum and corresponding node 
        Map<Integer, ListNode> cumulativeSumMap = new HashMap<>();
      
        int sum = 0; // Variable to hold the cumulative sum of node values
        ListNode current = dummyHead; // Current node, starting from the dummy head
      
        // First pass: Calculate cumulative sums and save the last occurrence 
        // of each sum in the HashMap
        while (current != null) {
            sum += current.val;
            cumulativeSumMap.put(sum, current);
            current = current.next;
        }
      
        sum = 0; // Reset the sum for the second pass
        current = dummyHead; // Reset current node to the dummy head
      
        // Second pass: Remove zero-sum sublists
        while (current != null) {
            sum += current.val; // Update the cumulative sum
          
            // If we have seen this sum before, it means the sublist between the 
            // previous occurrence and this one sums to zero
            current.next = cumulativeSumMap.get(sum).next;
          
            current = current.next; // Move to the next node
        }
      
        return dummyHead.next; // Return the updated list without the dummy head
    }
}