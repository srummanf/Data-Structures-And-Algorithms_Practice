import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}

class Main {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean reverse = false;

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                if (reverse) {
                    level.add(0, current.val);
                } else {
                    level.add(current.val);
                }
                if (current.left != null)
                    queue.offer(current.left);
                if (current.right != null)
                    queue.offer(current.right);
            }
            result.add(level);
            reverse = !reverse;
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        TreeNode root = createTree(input);

        Main main = new Main();
        List<List<Integer>> result = main.zigzagLevelOrder(root);

        for (List<Integer> level : result) {
            for (int num : level) {
                System.out.print(num + " ");
            }
        }
    }

    private static TreeNode createTree(String[] input) {
        if (input.length == 0 || input[0].equals("null")) {
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(input[0]));
        queue.offer(root);

        int i = 1;
        while (!queue.isEmpty() && i < input.length) {
            TreeNode curr = queue.poll();
            if (!input[i].equals("N")) {
                curr.left = new TreeNode(Integer.parseInt(input[i]));
                queue.offer(curr.left);
            }
            i++;
            if (i < input.length && !input[i].equals("N")) {
                curr.right = new TreeNode(Integer.parseInt(input[i]));
                queue.offer(curr.right);
            }
            i++;
        }

        return root;
    }
}
