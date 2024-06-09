class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int cap = 2;
        // Creating a 3D dp array of size [n][2][cap+1]
        int[][][] dp = new int[n][2][cap + 1];

        // Initialize the dp array with -1
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        // Calculate and return the maximum profit
        return getAns_memoization(prices, n, 0, 0, 2, dp);
    }

    public int getAns_memoization(
            int[] price,
            int n,
            int ind,
            int buy,
            int cap,
            int[][][] dp) {
        // Base case: If we have processed all stocks or have no capital left, return 0
        // profit
        if (ind == n || cap == 0)
            return 0;

        // If the result for this state is already calculated, return it
        if (dp[ind][buy][cap] != -1)
            return dp[ind][buy][cap];

        int profit = 0;

        if (buy == 0) { // We can buy the stock
            profit = Math.max(
                    0 + getAns_memoization(price, n, ind + 1, 0, cap, dp),
                    -price[ind] + getAns_memoization(price, n, ind + 1, 1, cap, dp));
        }

        if (buy == 1) { // We can sell the stock
            profit = Math.max(
                    0 + getAns_memoization(price, n, ind + 1, 1, cap, dp),
                    price[ind] + getAns_memoization(price, n, ind + 1, 0, cap - 1, dp));
        }

        // Store the calculated profit in the dp array and return it
        return dp[ind][buy][cap] = profit;
    }
}