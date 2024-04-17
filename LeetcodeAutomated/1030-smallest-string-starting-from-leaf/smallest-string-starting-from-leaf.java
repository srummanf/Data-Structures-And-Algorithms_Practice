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
    String ans = "";

    public void DFS(TreeNode root, String curr) {
        if (root == null)
            return;
        curr = (char) (root.val + 97) + curr;
        System.out.println(curr);
        if (root.left == null && root.right == null) {
            if (ans == "" || ans.compareTo(curr) > 0) {
                ans = curr;
            }
        }
        DFS(root.left, curr);
        DFS(root.right, curr);
    }

    public String smallestFromLeaf(TreeNode root) {
        DFS(root, "");
        return ans;
    }
}