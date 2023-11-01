import java.util.*;

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

  static class BinaryTree {

    static int idx = -1;

    public static Node buildTree(int nodes[]) {
      idx++;
      if (nodes[idx] == -1) {
        return null;
      }

      Node newNode = new Node(nodes[idx]);
      newNode.left = buildTree(nodes);
      newNode.right = buildTree(nodes);

      return newNode;
    }
  }

  public static void levelOrder(Node root) {
    if (root == null) return;
    Queue<Node> q = new LinkedList<>();
    q.add(root);
    q.add(null);

    while (!q.isEmpty()) {
      Node curr = q.remove();
      if (curr == null) {
        System.out.println();
        if (q.isEmpty()) {
          break;
        } else {
          q.add(null);
        }
      } else {
        System.out.print(curr.data + " ");
        if (curr.left != null) q.add(curr.left);
        if (curr.right != null) q.add(curr.right);
      }
    }
  }

  public static int countNodes(Node root) {
    if (root == null) return 0;
    return 1 + countNodes(root.left) + countNodes(root.right);
  }

  public static int sumNodes(Node root) {
    if (root == null) return 0;
    return root.data + sumNodes(root.left) + sumNodes(root.right);
  }

  public static int height(Node root) {
    if (root == null) return 0;
    return 1 + Math.max(height(root.left), height(root.right));
  }

  static class TreeInfo {

    int height;
    int diameter;

    TreeInfo(int h, int d) {
      this.height = h;
      this.diameter = d;
    }
  }

    // ---------------- get Tree Info --------------------------------------------------------------------------------------------------------------------------------


  public static TreeInfo getTreeInfo(Node root) {
    if (root == null) return new TreeInfo(0, 0);
    TreeInfo left = getTreeInfo(root.left);
    TreeInfo right = getTreeInfo(root.right);
    int height = 1 + Math.max(left.height, right.height);
    int diameter = Math.max(
      left.height + right.height + 1,
      Math.max(left.diameter, right.diameter)
    );
    return new TreeInfo(height, diameter);
  }

  // ---------------- isIdentical --------------------------------------------------------------------------------------------------------------------------------

  public boolean isIdentical(Node root, Node subroot) {
    if (root == null && subroot == null) return true;
    if (root == null || subroot == null) return false;
    if (root.data == subroot.data) {
      return (
        isIdentical(root.left, subroot.left) &&
        isIdentical(root.right, subroot.right)
      );
    }
    return false;
  }

  // ---------------- isSubTree --------------------------------------------------------------------------------------------------------------------------------

  public boolean isSubTree(Node root, Node subroot) {
    if (subroot == null) return true;
    if (root == null) return false;
    if (root.data == subroot.data) {
      if (isIdentical(root, subroot)) return true;
    }
    return isSubTree(root.left, subroot) || isSubTree(root.right, subroot);
  }

  // ----------------------------------------------------------------Main Method------------------------------------------------------------

  public static void main(String[] args) {
    int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
    BinaryTree b = new BinaryTree();
    Node root = b.buildTree(nodes);
    // System.out.println(root.data);
    // System.out.println(countNodes(root));
    // System.out.println(sumNodes(root));
    // System.out.println(height(root));
    System.out.println(getTreeInfo(root).diameter);
    //levelOrder(root);
  }
}
