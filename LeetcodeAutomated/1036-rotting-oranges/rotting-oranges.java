import java.util.*;

class Solution {
    // Directions for traversal: up, right, down, left
    private static final int[] DEL_ROW = { -1, 0, 1, 0 };
    private static final int[] DEL_COL = { 0, 1, 0, -1 };

    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int freshOranges = 0;

        // Initialize the queue with all rotten oranges' positions
        // and count the fresh oranges
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[] { i, j });
                } else if (grid[i][j] == 1) {
                    freshOranges++;
                }
            }
        }

        // If there are no fresh oranges, return 0 minutes
        if (freshOranges == 0) {
            return 0;
        }

        int minutesElapsed = -1;

        // BFS to spread the rot to adjacent fresh oranges
        while (!queue.isEmpty()) {
            int size = queue.size();
            minutesElapsed++;

            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                int row = current[0];
                int col = current[1];

                // Check all four directions
                for (int j = 0; j < 4; j++) {
                    int newRow = row + DEL_ROW[j];
                    int newCol = col + DEL_COL[j];

                    // If the new cell is within bounds and is a fresh orange, rot it
                    if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && grid[newRow][newCol] == 1) {
                        grid[newRow][newCol] = 2;
                        queue.add(new int[] { newRow, newCol });
                        freshOranges--;
                    }
                }
            }
        }

        // If there are still fresh oranges left, return -1
        return freshOranges == 0 ? minutesElapsed : -1;
    }
}
