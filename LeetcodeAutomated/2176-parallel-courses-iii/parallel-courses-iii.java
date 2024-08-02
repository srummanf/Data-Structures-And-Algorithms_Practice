import java.util.*;

class Solution {

    public int minimumTime(int n, int[][] relations, int[] time) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        int[] indegree = new int[n];
        for (int[] relation : relations) {
            int u = relation[0] - 1;
            int v = relation[1] - 1;
            adj.get(u).add(v);
            indegree[v]++;
        }

        int[] completionTime = new int[n];
        Queue<Integer> queue = new LinkedList<>();
        
        // Initialize the queue with nodes that have no prerequisites
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
                completionTime[i] = time[i];
            }
        }

        while (!queue.isEmpty()) {
            int course = queue.poll();
            for (int nextCourse : adj.get(course)) {
                indegree[nextCourse]--;
                completionTime[nextCourse] = Math.max(completionTime[nextCourse], completionTime[course] + time[nextCourse]);
                if (indegree[nextCourse] == 0) {
                    queue.add(nextCourse);
                }
            }
        }

        int minMonths = 0;
        for (int t : completionTime) {
            minMonths = Math.max(minMonths, t);
        }

        return minMonths;
    }
}
