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
    List<String> paths = new ArrayList<>();

    public int sumNumbers(TreeNode root) {
        generatePaths(root, "");
        int sum = 0;
        for (String path : paths) {
            sum += Integer.parseInt(path);
        }
        return sum;
    }

    void generatePaths(TreeNode node, String current) {
        if (node == null) return;
        current += node.val;
        if (node.left == null && node.right == null) {
            paths.add(current);
            return;
        }
        generatePaths(node.left, current);
        generatePaths(node.right, current);
    }

}