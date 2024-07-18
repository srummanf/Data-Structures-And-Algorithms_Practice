class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
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

        if(cnt==numCourses) return topo;
        return new int[0];
    }
}