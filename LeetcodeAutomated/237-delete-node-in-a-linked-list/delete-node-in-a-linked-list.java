class Solution {
    public void deleteNode(ListNode node) {
        if (node == null || node.next == null) {
            throw new IllegalArgumentException("Node to delete cannot be null or the last node.");
        }
        
        ListNode nextNode = node.next;
        node.val = nextNode.val;         // Copy value from the next node to the current node
        node.next = nextNode.next;       // Bypass the next node
    }
}
