class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        // Initialize the adjacency list
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        // Fill the adjacency list with prerequisites
        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int prerequisiteCourse = prerequisite[1];
            adj.get(prerequisiteCourse).add(course);
        }

        int[] topo = new int[numCourses];

        int[] indegree = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            for (Integer destNode : adj.get(i)) {
                indegree[destNode]++;
            }
        }

        Queue<Integer> q = new LinkedList<Integer>();

        // Adding nodes to queue with indegree = 0
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        int cnt = 0;
        int idx = 0;

        while (!q.isEmpty()) {
            int node = q.poll();
            topo[idx++] = node;
            cnt++;
            for (int ngh : adj.get(node)) {
                indegree[ngh]--;
                if (indegree[ngh] == 0) {
                    q.add(ngh);
                }
            }
        }

        if(cnt==numCourses) return true;
        return false;

    }
}

// Solution 2

// class Solution {

// public boolean canFinish(int numCourses, int[][] prerequisites) {
// ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
// for (int i = 0; i < numCourses; i++) {
// adj.add(new ArrayList<>());
// }
// for (int[] prerequisite : prerequisites) {
// int course = prerequisite[0];
// int prereq = prerequisite[1];
// adj.get(prereq).add(course);
// }
// int vis[] = new int[numCourses];
// int dfsVis[] = new int[numCourses];

// for (int i = 0; i < numCourses; i++) {
// if (vis[i] == 0) {
// if (checkCycle(i, adj, vis, dfsVis) == true)
// return false;
// }
// }
// return true;

// }

// private static boolean checkCycle(int node, ArrayList<ArrayList<Integer>>
// adj, int vis[], int dfsVis[]) {
// vis[node] = 1;
// dfsVis[node] = 1;

// for (Integer neighbor : adj.get(node)) {
// if (vis[neighbor] == 0) {
// if (checkCycle(neighbor, adj, vis, dfsVis) == true) {
// return true;
// }
// } else if (dfsVis[neighbor] == 1) {
// return true;
// }
// }
// dfsVis[node] = 0;
// return false;
// }
// }