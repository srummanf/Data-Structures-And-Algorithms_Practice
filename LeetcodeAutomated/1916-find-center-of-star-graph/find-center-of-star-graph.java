import java.util.*;

class Solution {
    public int findCenter(int[][] edges) {
        // Since it's a star graph, we can use the fact that the center node will appear in all the edges
        // More specifically, it will appear in the first two edges for sure
        // We can use this property to determine the center node

        int node1 = edges[0][0];
        int node2 = edges[0][1];
        int node3 = edges[1][0];
        int node4 = edges[1][1];
        
        if (node1 == node3 || node1 == node4) {
            return node1;
        } else {
            return node2;
        }
    }
}


// import java.util.*;

// class Solution {
//     public int findCenter(int[][] edges) {
//         // Determine the number of nodes from the edges
//         int n = edges.length + 1;

//         // Initialize the adjacency list
//         List<List<Integer>> adj = new ArrayList<>();
//         for (int i = 0; i <= n; i++) {
//             adj.add(new ArrayList<>());
//         }

//         // Populate the adjacency list
//         for (int[] edge : edges) {
//             int u = edge[0];
//             int v = edge[1];
//             adj.get(u).add(v);
//             adj.get(v).add(u);
//         }

//         // Find the center node
//         for (int i = 1; i <= n; i++) {
//             if (adj.get(i).size() == n - 1) {
//                 return i;
//             }
//         }

//         return -1; // If no center node is found
//     }
// }
