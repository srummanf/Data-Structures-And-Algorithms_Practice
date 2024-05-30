/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    int maxi = Integer.MIN_VALUE;

    public int height(TreeNode root) {
        if (root == null)
            return 0;

        int lh = Math.max(0, height(root.left));  // Calculate left height, discard if negative
        int rh = Math.max(0, height(root.right)); // Calculate right height, discard if negative

        // Update the maximum path sum considering the current node
        maxi = Math.max(maxi, root.val + lh + rh);

        // Return the maximum path sum passing through the current node
        return root.val + Math.max(lh, rh);
    }

    public int maxPathSum(TreeNode root) {
        height(root);
        return maxi;
    }
}
