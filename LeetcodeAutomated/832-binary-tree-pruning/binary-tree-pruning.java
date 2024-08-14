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
    public boolean isPresentOne(TreeNode root) {
        if (root == null)
            return false;
        if (root.val == 1)
            return true;
        return isPresentOne(root.left) || isPresentOne(root.right);
    }

    public TreeNode pruneTree(TreeNode root) {
        if (root == null)
            return null;
        if (!isPresentOne(root.left))
            root.left = null;
        if (!isPresentOne(root.right))
            root.right = null;
        pruneTree(root.left);
        pruneTree(root.right);

        if (root.val != 1 && root.left == null && root.right == null)
            return null;
        return root;
    }
}