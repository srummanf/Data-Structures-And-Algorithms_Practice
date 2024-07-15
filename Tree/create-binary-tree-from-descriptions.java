import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Definition for a binary tree node.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    /**
     * Creates a binary tree from a list of node descriptions.
     *
     * @param descriptions Array of triples describing the tree. Each triple contains the parent value,
     *                     child value, and a flag to indicate if the child is a left or right child.
     * @return The root of the constructed binary tree.
     */
    public TreeNode createBinaryTree(int[][] descriptions) {
        // Map to store the value and corresponding TreeNode
        Map<Integer, TreeNode> nodeMap = new HashMap<>();
      
        // Set to track visited child nodes
        Set<Integer> visited = new HashSet<>();

        // Loop through each description to build the tree
        for (int[] description : descriptions) {
            int parentValue = description[0];
            int childValue = description[1];
            int isLeftChild = description[2];

			// Ensure that a TreeNode exists for the parentValue
            if (!nodeMap.containsKey(parentValue)) {
                nodeMap.put(parentValue, new TreeNode(parentValue));
            }

            // Ensure that a TreeNode exists for the childValue
            if (!nodeMap.containsKey(childValue)) {
                nodeMap.put(childValue, new TreeNode(childValue));
            }

            // Link parent to child appropriately based on isLeftChild flag
            if (isLeftChild == 1) {
                nodeMap.get(parentValue).left = nodeMap.get(childValue);
            } else {
                nodeMap.get(parentValue).right = nodeMap.get(childValue);
            }

            // Mark the child as visited
            visited.add(childValue);
        }

        // Find the root of the binary tree (the node that was never visited as a child)
        for (Map.Entry<Integer, TreeNode> entry : nodeMap.entrySet()) {
            if (!visited.contains(entry.getKey())) {
                return entry.getValue();
            }
        }

        // In case no root is found (which shouldn't happen if input is valid), return null
        return null;
    }
}