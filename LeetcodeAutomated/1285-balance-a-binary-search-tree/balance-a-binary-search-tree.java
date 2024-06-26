import java.util.ArrayList;

public class Solution {
    ArrayList<Integer> vals = new ArrayList<>();

    // In-order traversal to get the sorted values
    public void traversal(TreeNode root) {
        if (root == null)
            return;
        traversal(root.left);
        vals.add(root.val);
        traversal(root.right);
    }

    public TreeNode balanceBST(TreeNode root) {
        // Get the sorted values from the BST
        traversal(root);
        // Build a balanced BST from the sorted values
        return buildBalancedBST(0, vals.size() - 1);
    }

    public TreeNode buildBalancedBST(int start, int end) {
        if (start > end)
            return null;
        int mid = start + (end - start) / 2;
        TreeNode node = new TreeNode(vals.get(mid));
        node.left = buildBalancedBST(start, mid - 1);
        node.right = buildBalancedBST(mid + 1, end);
        return node;
    }

    
}
