class Solution {
    public ListNode mergeNodes(ListNode head) {
        // Create a dummy node to act as the starting point of the new list
        ListNode dummyNode = new ListNode();
        // 'sum' will be used to calculate the sum of values between two zeros
        int sum = 0;
        // 'currentTail' refers to the current end of the new linked list
        ListNode currentTail = dummyNode;

        // Start processing nodes after the initial zero node
        for (ListNode currentNode = head.next; currentNode != null; currentNode = currentNode.next) {
            if (currentNode.val != 0) {
                // Add the current node's value to 'sum'
                sum += currentNode.val;
            } else {
                // If a zero node is found, create a new node with the sum and reset 'sum'
                currentTail.next = new ListNode(sum);
                // Move 'currentTail' to the new end node
                currentTail = currentTail.next;
                sum = 0; // Reset 'sum' as we started a new sum calculation
            }
        }

        // Return the next of dummyNode as it the head of the newly formed list
        return dummyNode.next;
    }
}