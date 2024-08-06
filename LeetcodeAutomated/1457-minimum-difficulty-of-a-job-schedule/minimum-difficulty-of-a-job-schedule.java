import java.util.Arrays;

class Solution {
    int[][] dp = new int[301][11];

    public int solve(int[] jd, int n, int idx, int d, int[][] dp) {
        if (d == 1) {
            int maxD = jd[idx];
            for (int i = idx; i < n; i++) {
                maxD = Math.max(maxD, jd[i]);
            }
            return maxD;
        }

        if (dp[idx][d] != -1) return dp[idx][d];

        int maxD = -1;
        int finalResult = Integer.MAX_VALUE;

        for (int i = idx; i <= n - d; i++) {
            maxD = Math.max(maxD, jd[i]);
            int result = maxD + solve(jd, n, i + 1, d - 1, dp);
            finalResult = Math.min(finalResult, result);
        }

        dp[idx][d] = finalResult;
        return dp[idx][d];
    }

    public int minDifficulty(int[] jd, int d) {
        for (int[] a : dp)
            Arrays.fill(a, -1);
        int n = jd.length;
        if (n < d)
            return -1;

        return solve(jd, n, 0, d, dp);
    }
}
