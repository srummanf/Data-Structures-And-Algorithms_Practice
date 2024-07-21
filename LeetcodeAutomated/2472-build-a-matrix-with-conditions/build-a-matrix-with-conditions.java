import java.util.*;

class Solution {

    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        // Step 1: Create graphs for row and column conditions
        ArrayList<ArrayList<Integer>> rowGraph = new ArrayList<>();
        ArrayList<ArrayList<Integer>> colGraph = new ArrayList<>();
        for (int i = 0; i <= k; i++) {
            rowGraph.add(new ArrayList<>());
            colGraph.add(new ArrayList<>());
        }

        int[] rowIndegree = new int[k + 1];
        int[] colIndegree = new int[k + 1];

        // Fill the row graph and calculate indegrees
        for (int[] condition : rowConditions) {
            rowGraph.get(condition[0]).add(condition[1]);
            rowIndegree[condition[1]]++;
        }

        // Fill the column graph and calculate indegrees
        for (int[] condition : colConditions) {
            colGraph.get(condition[0]).add(condition[1]);
            colIndegree[condition[1]]++;
        }

        // Step 2: Topological sorting for rows and columns
        int[] rowOrder = topoSort(k, rowGraph, rowIndegree);
        int[] colOrder = topoSort(k, colGraph, colIndegree);

        // If sorting fails, return empty matrix
        if (rowOrder.length != k || colOrder.length != k) {
            return new int[0][0];
        }

        // Step 3: Build the k x k matrix
        int[][] matrix = new int[k][k];
        Map<Integer, Integer> rowPosition = new HashMap<>();
        Map<Integer, Integer> colPosition = new HashMap<>();

        // Map each number to its row position
        for (int i = 0; i < k; i++) {
            rowPosition.put(rowOrder[i], i);
        }

        // Map each number to its column position
        for (int i = 0; i < k; i++) {
            colPosition.put(colOrder[i], i);
        }

        // Place each number in the matrix based on the row and column positions
        for (int i = 1; i <= k; i++) {
            matrix[rowPosition.get(i)][colPosition.get(i)] = i;
        }

        return matrix;
    }

    // Kahn's Algorithm for Topological Sort
    public int[] topoSort(int N, ArrayList<ArrayList<Integer>> adj, int[] indegree) {
        int[] topo = new int[N];
        Queue<Integer> q = new LinkedList<>();

        // Adding nodes to queue with indegree = 0
        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        int idx = 0;

        while (!q.isEmpty()) {
            int node = q.poll();
            topo[idx] = node;
            idx++;

            // Getting neighbor nodes of popped node and decreasing their indegree by 1
            for (Integer it : adj.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0) {
                    q.add(it);
                }
            }
        }

        // Check if topological sort was successful (all nodes included)
        return idx == N ? topo : new int[0];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int k = 3;
        int[][] rowConditions = { { 1, 2 }, { 3, 2 } };
        int[][] colConditions = { { 2, 1 }, { 3, 2 } };
        int[][] result = solution.buildMatrix(k, rowConditions, colConditions);

        for (int[] row : result) {
            System.out.println(Arrays.toString(row));
        }
    }
}
