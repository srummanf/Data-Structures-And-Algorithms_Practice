// i-1 * n-i

class Solution {
    public int f(int[] dp, int n) {
        if (n <= 1)
            return 1;
        if (dp[n] != -1)
            return dp[n];
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            ans += f(dp, i - 1) * f(dp, n - i);
        }
        return ans;
    }

    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return f(dp, n);

    }
}