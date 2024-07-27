class Solution {
    public int networkDelayTime(int[][] edges, int n, int src) {
        int[][] dist = new int[n + 1][n + 1];
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
            dist[i][i] = 0;
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int weight = edge[2];
            dist[u][v] = Math.min(dist[u][v], weight); // Handle multiple edges
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }
        for (int i = 1; i <= n; i++) {
             if (dist[src][i] == Integer.MAX_VALUE) {
                return -1; // If any node is unreachable from the source
            }
                ans = Math.max(ans, dist[src][i]);
        }

        return ans;
    }
}