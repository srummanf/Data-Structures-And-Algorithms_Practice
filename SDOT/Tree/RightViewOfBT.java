import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}

class MaxLevel {
    int level;
}

class Main {
    Node root;
    MaxLevel max = new MaxLevel();

    void rightViewUtil(Node node, int level, MaxLevel maxLevel) {
        if (node == null)
            return;
        if (maxLevel.level < level) {
            System.out.print(node.data + " ");
            maxLevel.level = level;
        }
        rightViewUtil(node.right, level + 1, maxLevel);
        rightViewUtil(node.left, level + 1, maxLevel);
    }

    void rightView() {
        rightView(root);
    }

    void rightView(Node node) {
        rightViewUtil(node, 1, max);
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int[] arr = new int[input.length];

        for (int i = 0; i < input.length; i++) {
            if (input[i].equals("N")) {
                arr[i] = Integer.MIN_VALUE;
            } else {
                arr[i] = Integer.parseInt(input[i]);
            }
        }

        Main tree = new Main();
        tree.root = tree.insertLevelOrder(arr, tree.root, 0);

        tree.rightView();
    }

    Node insertLevelOrder(int[] arr, Node root, int i) {
        if (i < arr.length) {
            if (arr[i] != Integer.MIN_VALUE) {
                Node temp = new Node(arr[i]);
                root = temp;
                root.left = insertLevelOrder(arr, root.left, 2 * i + 1);
                root.right = insertLevelOrder(arr, root.right, 2 * i + 2);
            } else {
                return null;
            }
        }
        return root;
    }
}
