class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (int[] i : dp)
            Arrays.fill(i, -1);
        return f(m, n, m - 1, n - 1, dp);
    }

    public int f(int m, int n, int i, int j, int[][] dp) {
        if (i == 0 && j == 0)
            return 1;
        if (i < 0 || j < 0)
            return 0;
        if (dp[i][j] != -1)
            return dp[i][j];
        int up = f(m, n, i - 1, j, dp);
        int left = f(m, n, i, j - 1, dp);
        return dp[i][j] = up + left;
    }
}