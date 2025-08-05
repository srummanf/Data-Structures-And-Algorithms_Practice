class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

class RecoverTheBST {

    private TreeNode first;
    private TreeNode prev;
    private TreeNode middle;
    private TreeNode last;

    private void inorder(TreeNode root) {

        if (root == null) {
            return;
        }

        inorder(root.left);

        if (prev != null && root.val < prev.val) {
            if (first == null) {
                first = prev;
                middle = root;
            } else {
                last = root;
            }
        }

        prev = root;

        inorder(root.right);
    }

    public void recoverTree(TreeNode root) {
        inorder(root);

        if (last != null) {
            int temp = first.val;
            first.val = last.val;
            last.val = temp;
        } else {
            int temp = first.val;
            first.val = middle.val;
            middle.val = temp;
        }
    }

    void printInorder(TreeNode root) {
        if (root == null) {
            return;
        }
        printInorder(root.left);
        System.out.print(root.val + " ");
        printInorder(root.right);
    }

    public static void main(String[] args) {
        RecoverTheBST main = new RecoverTheBST();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        main.recoverTree(root);
        main.printInorder(root);
    }
}
