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
    ArrayList<String> ans = new ArrayList<>();
    public void DFS(TreeNode root, ArrayList<String> curr){
        if(root==null) return;

        curr.add(Integer.toString(root.val));

        if(root.left==null && root.right==null){
            System.out.println(ans);
            String result = String.join("->", curr);
            ans.add(result);
        }
        else{
        DFS(root.left, curr);
        DFS(root.right, curr);
        }
        curr.remove(curr.size()-1);
    }
    public List<String> binaryTreePaths(TreeNode root) {
         ArrayList<String> curr = new ArrayList<>();
        DFS(root, curr);
        return ans;
    }
}