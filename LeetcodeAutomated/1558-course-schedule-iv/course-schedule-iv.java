import java.util.*;

class Solution {
    public boolean bfs(int V, ArrayList<ArrayList<Integer>> adj, int src, int dest) {
        boolean[] vis = new boolean[V];
        Queue<Integer> q = new LinkedList<>();

        q.add(src);
        vis[src] = true;

        while (!q.isEmpty()) {
            int node = q.poll();
            if (node == dest) return true;

            // Traverse all neighbors
            for (int neighbor : adj.get(node)) {
                if (!vis[neighbor]) {
                    vis[neighbor] = true;
                    q.add(neighbor);
                }
            }
        }

        return false;
    }

    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        // Create the adjacency list for the graph
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : prerequisites) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v); // Directed graph
        }

        List<Boolean> ans = new ArrayList<>();
        for (int[] query : queries) {
            int src = query[0];
            int dest = query[1];
            ans.add(bfs(numCourses, adj, src, dest));
        }

        return ans;
    }
}
