/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // If both trees are empty, they are the same.
        if (p == null && q == null) return true;

        // If one of the trees is empty or the values of current nodes don't match,
        // the trees aren't the same.
        if (p == null || q == null || p.val != q.val) return false;

        // Recursively check if the left subtree of both trees are the same 
        // AND the right subtree of both trees are the same.
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}