class Solution {

    private TreeNode lowestCommonAncestor(TreeNode root, int src, int dest) {
        if (root == null) {
            return null;
        }
        
        if (root.val == src || root.val == dest) {
            return root;
        }
        
        TreeNode left = lowestCommonAncestor(root.left, src, dest);
        TreeNode right = lowestCommonAncestor(root.right, src, dest);
        
        if (left != null && right != null) {
            return root;
        }
        
        return left != null ? left : right;
    }

    private boolean findPath(TreeNode node, int target, StringBuilder path) {
        if (node == null) {
            return false;
        }

        if (node.val == target) {
            return true;
        }

        path.append('L');
        if (findPath(node.left, target, path)) {
            return true;
        }
        path.deleteCharAt(path.length() - 1);

        path.append('R');
        if (findPath(node.right, target, path)) {
            return true;
        }
        path.deleteCharAt(path.length() - 1);

        return false;
    }

    public String getDirections(TreeNode root, int startValue, int destValue) {
        TreeNode LCA = lowestCommonAncestor(root, startValue, destValue);

        StringBuilder lcaToStart = new StringBuilder();
        StringBuilder lcaToDest = new StringBuilder();

        findPath(LCA, startValue, lcaToStart);
        findPath(LCA, destValue, lcaToDest);

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < lcaToStart.length(); i++) {
            result.append('U');
        }

        result.append(lcaToDest);

        return result.toString();
    }
}


// public class Solution {

//     public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//         if (root == null || root == p || root == q) return root;

//         TreeNode left = lowestCommonAncestor(root.left, p, q);
//         TreeNode right = lowestCommonAncestor(root.right, p, q);

//         if (left == null) return right;
//         if (right == null) return left;
//         return root;
//     }

//     private boolean findPath(TreeNode root, int value, StringBuilder path) {
//         if (root == null) return false;
//         if (root.val == value) return true;

//         path.append('L');
//         if (findPath(root.left, value, path)) return true;
//         path.deleteCharAt(path.length() - 1);

//         path.append('R');
//         if (findPath(root.right, value, path)) return true;
//         path.deleteCharAt(path.length() - 1);

//         return false;
//     }

//     public String getDirections(TreeNode root, int startValue, int destValue) {
//         TreeNode lca = lowestCommonAncestor(root, findNode(root, startValue), findNode(root, destValue));

//         StringBuilder pathToStart = new StringBuilder();
//         StringBuilder pathToDest = new StringBuilder();

//         findPath(lca, startValue, pathToStart);
//         findPath(lca, destValue, pathToDest);

//         StringBuilder result = new StringBuilder();

//         for (int i = 0; i < pathToStart.length(); i++) {
//             result.append('U');
//         }

//         result.append(pathToDest.toString());

//         return result.toString();
//     }

//     private TreeNode findNode(TreeNode root, int value) {
//         if (root == null) return null;
//         if (root.val == value) return root;
//         TreeNode left = findNode(root.left, value);
//         if (left != null) return left;
//         return findNode(root.right, value);
//     }

    
// }
