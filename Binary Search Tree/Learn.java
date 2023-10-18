public class Learn {

  static class Node {

    int data;
    Node left;
    Node right;

    Node(int data) {
      this.data = data;
      this.left = null;
      this.right = null;
    }
  }

  public static Node insert(Node root, int val) {
    if (root == null) {
      root = new Node(val);
      return root;
    }
    if (val < root.data) {
      root.left = insert(root.left, val);
    } else {
      root.right = insert(root.right, val);
    }
    return root;
  }

  public static void inorder(Node root) {
    if (root == null) return;
    inorder(root.left);
    System.out.print(root.data + " ");
    inorder(root.right);
  }

  public static boolean search(Node root, int key) {
    if (root == null) return false;
    if (root.data > key) {
      return search(root.left, key);
    } else if (root.data == key) {
      return true;
    } else {
      return search(root.right, key);
    }
  }

  public static void main(String[] args) {
    int val[] = { 5, 1, 3, 4, 2, 7 };
    Node root = null;
    for (int x : val) {
      root = insert(root, x);
    }
    inorder(root);
    System.out.println(search(root, 7));
  }
}
