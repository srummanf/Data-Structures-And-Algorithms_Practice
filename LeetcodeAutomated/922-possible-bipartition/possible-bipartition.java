// Backtracking Solution

// class Solution {

//     // public boolean isPossible(int node, int color, int[][] dislikes, int[] col) {
//     // for (int[] i : dislikes) {
//     // int parent = i[0];
//     // int ngh = i[1];
//     // if (parent == node && col[ngh]==color)
//     // return false;
//     // }
//     // return true;
//     // }

//     public boolean isPossible(int node, int color, int[][] dislikes, int[] col) {
//         for (int[] i : dislikes) {
//             int u = i[0];
//             int v = i[1];
//             if (u == node && col[v] == color)
//                 return false;
//             if (v == node && col[u] == color)
//                 return false;
//         }
//         return true;
//     }

//     public boolean coloring(int node, int n, int[][] dislikes, int[] col) {
//         // if(node==n) return true wont work as graph is 1 based indexing
//         if (node > n)
//             return true;
//         for (int color = 1; color <= 2; color++) {
//             if (isPossible(node, color, dislikes, col)) {
//                 col[node] = color;
//                 if (coloring(node + 1, n, dislikes, col))
//                     return true;
//                 col[node] = -1;
//             }
//         }
//         return false;
//     }

//     public boolean possibleBipartition(int n, int[][] dislikes) {
//         int[] col = new int[n + 1];
//         return coloring(1, n, dislikes, col);

//     }
// }

import java.util.*;

class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        // Create the adjacency list for the graph
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] dislike : dislikes) {
            int u = dislike[0];
            int v = dislike[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        
        // Color array: 0 means uncolored, 1 and 2 are the two colors
        int[] color = new int[n + 1];
        Arrays.fill(color, 0);

        // Check bipartiteness for all components
        for (int i = 1; i <= n; i++) {
            if (color[i] == 0) { // If the node is uncolored, start BFS
                if (!bfs(i, graph, color)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean bfs(int start, List<List<Integer>> graph, int[] color) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        color[start] = 1; // Start coloring with color 1

        while (!queue.isEmpty()) {
            int node = queue.poll();
            int currentColor = color[node];
            int nextColor = (currentColor == 1) ? 2 : 1;

            for (int neighbor : graph.get(node)) {
                if (color[neighbor] == 0) {
                    // Not colored yet
                    color[neighbor] = nextColor;
                    queue.offer(neighbor);
                } else if (color[neighbor] == currentColor) {
                    // Conflict detected
                    return false;
                }
            }
        }

        return true;
    }
}

