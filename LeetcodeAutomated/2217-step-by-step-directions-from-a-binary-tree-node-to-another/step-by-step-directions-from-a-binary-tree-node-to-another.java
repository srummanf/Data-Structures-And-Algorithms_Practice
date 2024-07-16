class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left == null) return right;
        if (right == null) return left;
        return root;
    }

    private boolean findPath(TreeNode root, int value, StringBuilder path) {
        if (root == null) return false;
        if (root.val == value) return true;

        path.append('L');
        if (findPath(root.left, value, path)) return true;
        path.deleteCharAt(path.length() - 1);

        path.append('R');
        if (findPath(root.right, value, path)) return true;
        path.deleteCharAt(path.length() - 1);

        return false;
    }

    public String getDirections(TreeNode root, int startValue, int destValue) {
        TreeNode lca = lowestCommonAncestor(root, findNode(root, startValue), findNode(root, destValue));

        StringBuilder pathToStart = new StringBuilder();
        StringBuilder pathToDest = new StringBuilder();

        findPath(lca, startValue, pathToStart);
        findPath(lca, destValue, pathToDest);

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < pathToStart.length(); i++) {
            result.append('U');
        }

        result.append(pathToDest.toString());

        return result.toString();
    }

    private TreeNode findNode(TreeNode root, int value) {
        if (root == null) return null;
        if (root.val == value) return root;
        TreeNode left = findNode(root.left, value);
        if (left != null) return left;
        return findNode(root.right, value);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(4);

        Solution sol = new Solution();
        System.out.println(sol.getDirections(root, 3, 6)); // Output: "UURL"
    }
}
