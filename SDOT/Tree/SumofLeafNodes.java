import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Main {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return null;
        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return root;
        }
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n1 = scanner.nextInt();
        int n2 = scanner.nextInt();

        TreeNode root = new TreeNode(scanner.nextInt());
        while (scanner.hasNextInt()) {
            int val = scanner.nextInt();
            if (val == -1)
                break; // Assuming the last value as a marker for no further nodes
            TreeNode node = new TreeNode(val);
            insert(root, node);
        }

        TreeNode p = new TreeNode(n1);
        TreeNode q = new TreeNode(n2);

        Main solution = new Main();
        TreeNode result = solution.lowestCommonAncestor(root, p, q);
        System.out.println(result.val);
    }

    // Function to insert a node into BST
    private static void insert(TreeNode root, TreeNode node) {
        if (node.val < root.val) {
            if (root.left == null) {
                root.left = node;
            } else {
                insert(root.left, node);
            }
        } else {
            if (root.right == null) {
                root.right = node;
            } else {
                insert(root.right, node);
            }
        }
    }
}
