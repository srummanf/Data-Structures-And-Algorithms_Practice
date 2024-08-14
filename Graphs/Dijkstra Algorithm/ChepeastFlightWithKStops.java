
/**  */

import java.util.*;

class Solution {
    private int check(int node, int[] parent, int[] price, int k) {
        if (node == -1) return 0;
        if (node == k + 2) return price[node]; 
        return price[node] + check(parent[node], parent, price, k);
    }

    private void printPaths(int start, int[] parent, int[] price, int k) {
        for (int i = 0; i < parent.length; i++) {
            if (i != start) {
                System.out.println("Price to reach node " + i + " is " + check(i, parent, price, k));
            }
        }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] flight : flights) {
            int from = flight[0];
            int to = flight[1];
            int price = flight[2];
            adjList.get(from).add(new int[] { to, price });
        }

        int[] dist = new int[n];
        int[] parent = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(parent, -1);
        dist[src] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]); // {node, price, stops}
        pq.offer(new int[]{ src, 0, 0 });

        while (!pq.isEmpty()) {
            int[] travel = pq.poll();
            int u = travel[0];
            int currPrice = travel[1];
            int stops = travel[2];

            if (u == dst) return currPrice;

            if (stops > k) continue;

            for (int[] ngh : adjList.get(u)) {
                int v = ngh[0];
                int price = ngh[1];
                if (currPrice + price < dist[v]) {
                    dist[v] = currPrice + price;
                    parent[v] = u;
                    pq.offer(new int[] { v, dist[v], stops + 1 });
                }
            }
        }

        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
}
