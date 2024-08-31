import java.util.*;

class Solution {
    class Pair {
        int dest;
        double prob;

        Pair(int dest, double prob) {
            this.dest = dest;
            this.prob = prob;
        }
    }

    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        // Initialize adjacency list
        List<List<Pair>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        
        // Build the adjacency list
        int idx = 0;
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            double p = succProb[idx++];
            adjList.get(u).add(new Pair(v, p));
            adjList.get(v).add(new Pair(u, p)); // Assuming undirected graph
        }

        // Initialize distance array
        double[] dist = new double[n];
        Arrays.fill(dist, 0.0); // Changed from Integer.MIN_VALUE to 0.0
        dist[start] = 1.0;

        // PriorityQueue for max heap based on probability
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Double.compare(b.prob, a.prob));
        pq.offer(new Pair(start, 1.0));

        while (!pq.isEmpty()) { // Changed from pq.isEmpty() == false to !pq.isEmpty()
            Pair curr = pq.poll();
            int u = curr.dest;
            double p = curr.prob;

            if (p < dist[u])
                continue;

            for (Pair ngh : adjList.get(u)) {
                int v = ngh.dest;
                double ngh_p = ngh.prob;
                if (dist[u] * ngh_p > dist[v]) {
                    dist[v] = dist[u] * ngh_p;
                    pq.offer(new Pair(v, dist[v])); // Add updated probability to priority queue
                }
            }
        }

        return dist[end];
    }
}
