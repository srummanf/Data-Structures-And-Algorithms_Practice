class Solution {
    public int secondMinimum(int n, int[][] edges, int time, int change) {
        // 1, Graph Creation
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        // 2. Distance Array for Dijkstra Algo
        int[] d1 = new int[n + 1];
        int[] d2 = new int[n + 1];
        Arrays.fill(d1, Integer.MAX_VALUE);
        Arrays.fill(d2, Integer.MAX_VALUE);

        // 3. Priority Queue for Dijkstra Algo -- {dist, node} -- Arrange in ascending
        // order of the distances
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        // 4. Adding the source info -- distance of src to src is 0 and our src is 1.
        pq.offer(new int[] { 0, 1 });
        d1[1] = 0;

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int timePassed = curr[0];
            int node = curr[1];

            if (d2[n] != Integer.MAX_VALUE && node == n)
                return d2[n];

            int mult = timePassed / change;
            if (mult % 2 == 1) {
                // Red light;
                timePassed = change * (mult + 1);
            }

            for (int nbr : adj.get(node)) {
                if (d1[nbr] > timePassed + time) {
                    d2[nbr] = d1[nbr];
                    d1[nbr] = timePassed + time;
                    pq.offer(new int[] { timePassed + time, nbr });
                } else if (d2[nbr] > timePassed + time && d1[nbr] != timePassed + time) {
                    d2[nbr] = timePassed + time;
                    pq.offer(new int[] { timePassed + time, nbr });
                }
            }
        }

        return -1;

    }
}