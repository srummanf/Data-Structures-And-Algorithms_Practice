import java.util.*;

class Solution {
    public void DFS(int ancestor, Map<Integer, List<Integer>> adj, int currNode, List<List<Integer>> result) {
        for (int ngbr : adj.getOrDefault(currNode, new ArrayList<>())) {
            if (result.get(ngbr).isEmpty() || result.get(ngbr).get(result.get(ngbr).size() - 1) != ancestor) {
                result.get(ngbr).add(ancestor);
                DFS(ancestor, adj, ngbr, result);
            }
        }
    }

    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, List<Integer>> adj = new HashMap<>();

        for (int i = 0; i < n; i++) {
            result.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
        }

        for (int i = 0; i < n; i++) {
            DFS(i, adj, i, result);
        }

        for (List<Integer> ancestors : result) {
            Collections.sort(ancestors);
        }

        return result;
    }


}
