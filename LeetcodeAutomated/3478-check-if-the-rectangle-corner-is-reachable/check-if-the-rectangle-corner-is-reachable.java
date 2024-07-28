import java.util.*;

class Solution {
    private boolean bfs(List<List<Integer>> graph, int start, int target1, int target2, int n) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n + 4];
        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor : graph.get(node)) {
                if (!visited[neighbor]) {
                    queue.offer(neighbor);
                    visited[neighbor] = true;
                }
            }
        }
        return visited[target1] || visited[target2];
    }

    public boolean canReachCorner(int X, int Y, int[][] circles) {
        int numCircles = circles.length;
        List<int[]> circleList = new ArrayList<>();
        List<List<Integer>> graph = new ArrayList<>(numCircles + 4);

        for (int i = 0; i < numCircles + 4; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] circle : circles) {
            circleList.add(new int[]{circle[0], circle[1], circle[2]});
        }

        for (int i = 0; i < numCircles; ++i) {
            int[] circle = circleList.get(i);
            int cx = circle[0], cy = circle[1], r = circle[2];

            if (cx <= r) {
                graph.get(numCircles).add(i);
                graph.get(i).add(numCircles);
            }
            if (X - cx <= r) {
                graph.get(numCircles + 2).add(i);
                graph.get(i).add(numCircles + 2);
            }
            if (cy <= r) {
                graph.get(numCircles + 1).add(i);
                graph.get(i).add(numCircles + 1);
            }
            if (Y - cy <= r) {
                graph.get(numCircles + 3).add(i);
                graph.get(i).add(numCircles + 3);
            }

            for (int j = i + 1; j < numCircles; ++j) {
                int[] otherCircle = circleList.get(j);
                int ocx = otherCircle[0], ocy = otherCircle[1], or = otherCircle[2];
                double distance = Math.sqrt(Math.pow(cx - ocx, 2) + Math.pow(cy - ocy, 2));
                if (r + or >= distance) {
                    graph.get(i).add(j);
                    graph.get(j).add(i);
                }
            }
        }

        return !(bfs(graph, numCircles, numCircles + 1, numCircles + 2, numCircles + 4) ||
                 bfs(graph, numCircles + 3, numCircles + 2, numCircles + 1, numCircles + 4));
    }

}
