import java.util.Arrays;

class Solution {

    private long f(int i, long sum, int[] r, long[][] dp) {
        if (i == r.length) return sum;

        if (dp[i][(int)sum] != -1) return dp[i][(int)sum];
        long ans = 0;
        if (sum < r[i]) ans = Math.max(f(i + 1, sum + r[i], r, dp), ans);
        ans = Math.max(f(i + 1, sum, r, dp), ans);

        return dp[i][(int)sum] = ans;
    }

    public int maxTotalReward(int[] r) {
        Arrays.sort(r);
        int n = r.length;
        long[][] dp = new long[n][4000];
        for (long[] row : dp) {
            Arrays.fill(row, -1);
        }

        return (int) f(0, 0, r, dp);
    }
    
}
