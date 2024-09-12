import java.util.Collections;
class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int nodes = graph.length;
        for (int i = 0; i < nodes; i++) {
            adj.add(new ArrayList<Integer>());
        }
        int idx = 0;
        for (int[] row : graph) {
            if (row.length >= 1)
                for (int a : row) {
                    adj.get(a).add(idx);
                }
            idx++;
        }
        List<Integer> topo = topoSort(nodes, adj);
        System.out.println(topo);
        Collections.sort(topo);
        return topo;

    }

    public List<Integer> topoSort(int N, ArrayList<ArrayList<Integer>> adj) {
        List<Integer> topo = new ArrayList<>();
        int[] indegree = new int[N];

        // Finding Indegree
        for (int i = 0; i < N; i++) {
            for (int destNode : adj.get(i)) {
                indegree[destNode]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        // Adding nodes to queue with indegree = 0
        for (int i = 0; i < N; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        int idx = 0;

        while (!q.isEmpty()) {
            int node = q.poll();
            // this node is very important -- for any other questions, use this node only
            topo.add(node);
            idx++;

            // Getting neighbour nodes of popped node and decreasing their indegree by 1
            for (int ngh : adj.get(node)) {
                indegree[ngh]--;
                if (indegree[ngh] == 0) {
                    q.add(ngh);
                }
            }
        }

        return topo;
    }
}