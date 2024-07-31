class Solution {
    final int MOD = 1000000007;

    public int numTilings(int n) {
        int dp[] = new int[n + 1];
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;
        if (n == 3)
            return 5;

        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 5;

        // dp[n] = 2*dp[n-1] + dp[n-3];
        for (int i = 4; i <= n; i++) {
            // dp[i] = (2 * dp[i - 1] % MOD + dp[n - 3] % MOD) % MOD;
            dp[i] = (2 * dp[i - 1] % MOD + dp[i - 3] % MOD) % MOD;
        }

        return dp[n];
    }
}