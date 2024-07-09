class Solution {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int prereq = prerequisite[1];
            adj.get(prereq).add(course);
        }
        int vis[] = new int[numCourses];
        int dfsVis[] = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (vis[i] == 0) {
                if (checkCycle(i, adj, vis, dfsVis) == true)
                    return false;
            }
        }
        return true;

    }

    private static boolean checkCycle(int node, ArrayList<ArrayList<Integer>> adj, int vis[], int dfsVis[]) {
        vis[node] = 1;
        dfsVis[node] = 1;

        for (Integer neighbor : adj.get(node)) {
            if (vis[neighbor] == 0) {
                if (checkCycle(neighbor, adj, vis, dfsVis) == true) {
                    return true;
                }
            } else if (dfsVis[neighbor] == 1) {
                return true;
            }
        }
        dfsVis[node] = 0;
        return false;
    }
}