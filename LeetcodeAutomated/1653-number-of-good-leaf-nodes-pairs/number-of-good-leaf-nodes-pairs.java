import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) { 
        this.val = val; 
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Solution {

    private TreeNode lowestCommonAncestor(TreeNode root, int src, int dest) {
        if (root == null || root.val == src || root.val == dest) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, src, dest);
        TreeNode right = lowestCommonAncestor(root.right, src, dest);

        return left != null && right != null ? root : (left != null ? left : right);
    }

    private int findDistance(TreeNode root, int value, int distance) {
        if (root == null) {
            return -1;
        }

        if (root.val == value) {
            return distance;
        }

        int leftDistance = findDistance(root.left, value, distance + 1);
        if (leftDistance != -1) {
            return leftDistance;
        }

        return findDistance(root.right, value, distance + 1);
    }

    public int distanceBetweenNodes(TreeNode root, int src, int dest) {
        if (root == null) {
            return -1;
        }

        TreeNode LCA = lowestCommonAncestor(root, src, dest);
        int distanceFromLCAtoSrc = findDistance(LCA, src, 0);
        int distanceFromLCAtoDest = findDistance(LCA, dest, 0);

        if (distanceFromLCAtoSrc == -1 || distanceFromLCAtoDest == -1) {
            return -1;
        }

        return distanceFromLCAtoSrc + distanceFromLCAtoDest;
    }

    private int countPairsHelper(TreeNode root, int distance, List<Integer> leafDistances) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            leafDistances.add(1); // Distance of leaf to itself is 1
            return 0;
        }

        List<Integer> leftLeafDistances = new ArrayList<>();
        List<Integer> rightLeafDistances = new ArrayList<>();

        int leftPairs = countPairsHelper(root.left, distance, leftLeafDistances);
        int rightPairs = countPairsHelper(root.right, distance, rightLeafDistances);

        int count = leftPairs + rightPairs;

        for (int lDist : leftLeafDistances) {
            for (int rDist : rightLeafDistances) {
                if (lDist + rDist <= distance) {
                    count++;
                }
            }
        }

        for (int lDist : leftLeafDistances) {
            leafDistances.add(lDist + 1);
        }
        for (int rDist : rightLeafDistances) {
            leafDistances.add(rDist + 1);
        }

        return count;
    }

    public int countPairs(TreeNode root, int distance) {
        if (root == null) {
            return 0;
        }

        List<Integer> leafDistances = new ArrayList<>();
        return countPairsHelper(root, distance, leafDistances);
    }

   
}
