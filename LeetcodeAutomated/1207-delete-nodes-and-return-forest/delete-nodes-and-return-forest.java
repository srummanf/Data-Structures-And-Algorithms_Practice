// /**
//  * Definition for a binary tree node.
//  * public class TreeNode {
//  * int val;
//  * TreeNode left;
//  * TreeNode right;
//  * TreeNode() {}
//  * TreeNode(int val) { this.val = val; }
//  * TreeNode(int val, TreeNode left, TreeNode right) {
//  * this.val = val;
//  * this.left = left;
//  * this.right = right;
//  * }
//  * }
//  */
// class Solution {
//     ArrayList<TreeNode> ans = new ArrayList<>();

//     public void dfs(TreeNode root, boolean isRoot, HashSet<Integer> hash) {
//         if (root == null)
//             return;

//         if (hash.contains(root.val)) {
//             dfs(root.left, true, hash);
//             dfs(root.right, true, hash);
//         } else {
//             if(isRoot) ans.add(root);
//             TreeNode left = root.left;
//             TreeNode right = root.right;

//             if(root.left!=null){
//                 if(hash.contains(root.left.val)){
//                     root.left = null;
//                 }
//             }
//             if(root.right!=null){
//                 if(hash.contains(root.right.val)){
//                     root.right = null;
//                 }
//             }
//             dfs(root.left, false, hash);
//             dfs(root.right, false, hash);
//         }

//     }

//     public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
//         HashSet<Integer> hash = new HashSet<>();
//         for (int i : to_delete) {
//             hash.add(i);
//         }
//         dfs(root, true, hash);
//         return ans;

//     }
// }

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
    ArrayList<TreeNode> ans = new ArrayList<>();

    public void dfs(TreeNode root, boolean isRoot, HashSet<Integer> toDeleteSet) {
        if (root == null) return;

        boolean toDelete = toDeleteSet.contains(root.val);
        if (isRoot && !toDelete) {
            ans.add(root);
        }

        if (root.left != null) {
            if (toDeleteSet.contains(root.left.val)) {
                dfs(root.left, true, toDeleteSet);
                root.left = null;
            } else {
                dfs(root.left, false, toDeleteSet);
            }
        }

        if (root.right != null) {
            if (toDeleteSet.contains(root.right.val)) {
                dfs(root.right, true, toDeleteSet);
                root.right = null;
            } else {
                dfs(root.right, false, toDeleteSet);
            }
        }

        if (toDelete) {
            dfs(root.left, true, toDeleteSet);
            dfs(root.right, true, toDeleteSet);
        }
    }

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        HashSet<Integer> toDeleteSet = new HashSet<>();
        for (int value : to_delete) {
            toDeleteSet.add(value);
        }
        dfs(root, true, toDeleteSet);
        return ans;
    }
}
