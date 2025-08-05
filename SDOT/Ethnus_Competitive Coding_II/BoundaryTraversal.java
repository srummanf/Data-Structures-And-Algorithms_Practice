import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;

    public TreeNode(int value) {
        val = value;
        left = right = null;
    }
}

public class BoundaryTraversal {
 
    private static void printLeaves(TreeNode root) {
        if (root != null) {
            printLeaves(root.left);
            if (root.left == null && root.right == null)
                System.out.print(root.val + " ");
            printLeaves(root.right);
        }
    }

    public static void boundaryTraversal(TreeNode root) {
        if (root != null) {
            System.out.print(root.val + " ");
            printLeaves(root.left);
            printLeaves(root.right);
        }
    }

    public static void main(String[] args) {
        // Constructing the example tree
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(3);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(6);
        root.left.right.left = new TreeNode(4);
        root.left.right.right = new TreeNode(7);
        root.right.right = new TreeNode(14);
        root.right.right.left = new TreeNode(13);

        // Calling the boundaryTraversal function
        boundaryTraversal(root);
        System.out.println();
        printLeaves(root);
    }
}


// insert(root, val){
//     if(root.left==null and root.right==null){
//         return root = new TreeNode(val);
//     } else if(val < root.left){
//         root.left = insert(root.left, val);
//     } else {
//         insert(root.right, val);
//     }
// }
// TreeNode root = null;
