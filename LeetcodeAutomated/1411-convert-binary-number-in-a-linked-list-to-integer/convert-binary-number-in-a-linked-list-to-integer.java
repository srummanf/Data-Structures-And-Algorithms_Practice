class Solution {
    public int getDecimalValue(ListNode head) {
        int count = 1; // Initialize power multiplier
        int num = 0;   // Final decimal value
        ListNode cur = head;

        // First pass: find the length of the list to determine the initial power of 2
        while (cur != null) {
            cur = cur.next;
            count *= 2; // Double count for each node to simulate shifting left
        }

        count /= 2; // Adjust count (it will be one step too far after last iteration)

        cur = head; // Reset pointer to head

        // Second pass: compute decimal value
        while (cur != null) {
            num += cur.val * count; // Add the current bit's decimal contribution
            count /= 2;             // Move to the next lower power of 2
            cur = cur.next;
        }

        return num; // Return the final decimal number
    }
}