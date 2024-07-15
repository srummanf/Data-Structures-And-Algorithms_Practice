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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root==null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            int size = queue.size(); 
            ArrayList<Integer> currLevel = new ArrayList<>();

            for(int i=0; i<size; i++){
                TreeNode currNode = queue.poll();
                currLevel.add(currNode.val);

                if(currNode.left !=null) queue.add(currNode.left);
                if(currNode.right !=null) queue.add(currNode.right);
            }

            result.add(currLevel);
        }
        return  result;
    }
}