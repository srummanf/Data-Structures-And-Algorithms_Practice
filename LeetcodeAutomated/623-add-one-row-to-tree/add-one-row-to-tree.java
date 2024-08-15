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
    public TreeNode addOne(TreeNode root, int val, int depth, int curr) {
        if (root == null)
            return null;
        if (curr == depth - 1) {
            TreeNode l = root.left;
            TreeNode r = root.right;
            root.left = new TreeNode(val);
            root.right = new TreeNode(val);
            root.left.left = l;
            root.right.right = r;
            return root;
        }

        root.left = addOne(root.left, val, depth, curr + 1);
        root.right = addOne(root.right, val, depth, curr + 1);

        return root;

    }

    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            TreeNode newroot = new TreeNode(val);
            newroot.left = root;
            return newroot;
        }
        int curr = 1;
        return addOne(root, val, depth, curr);
    }
}