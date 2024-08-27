class Solution {

    public List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        traversePostorder(root, result);
        return result;
    }

    private void traversePostorder(
        Node currentNode,
        List<Integer> postorderList
    ) {
        if (currentNode == null) {
            return;
        }

        // First, visit all children
        for (Node childNode : currentNode.children) {
            traversePostorder(childNode, postorderList);
        }

        // Then, add the current node's value
        postorderList.add(currentNode.val);
    }
}