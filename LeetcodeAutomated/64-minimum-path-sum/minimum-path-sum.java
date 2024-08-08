class Solution {
    int sum = 0;

    public static int topdown(int i, int j, int[][] maze, int[][] dp) {
        if (i == 0 && j == 0)
            return dp[i][j] = maze[i][j];
        if (i < 0 || j < 0)
            return 1000000;
        if (dp[i][j] != -1)
            return dp[i][j];
        int up = maze[i][j] + topdown(i - 1, j, maze, dp);
        int down = maze[i][j] + topdown(i, j - 1, maze, dp);
        return dp[i][j] = Math.min(up, down);
    }

    public int minPathSum(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        int dp[][] = new int[r + 1][c + 1];
        for (int i = 0; i < (r + 1); i++) {
            for (int j = 0; j < (c + 1); j++) {
                dp[i][j] = -1;
            }
        }

        return topdown(r - 1, c - 1, grid, dp);
    }
}