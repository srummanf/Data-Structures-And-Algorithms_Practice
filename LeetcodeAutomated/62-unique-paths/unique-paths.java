class Solution {

    public int f(int i, int j, int m, int n, int[][] dp) {
        if (i < 0 || j < 0)
            return 0;
        if (i == 0 && j == 0)
            return 1;
        if (dp[i][j] != -1)
            return dp[i][j];
        int up = f(i - 1, j, m, n, dp);
        int left = f(i, j - 1, m, n, dp);
        return dp[i][j] = up + left;

    }

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (int[] a : dp)
            Arrays.fill(a, -1);
        return f(m - 1, n - 1, m, n, dp);
    }
}