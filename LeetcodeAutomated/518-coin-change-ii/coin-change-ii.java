// f(2,4) in index 2 how many ways can i form target 4
class Solution {
    public int f(int idx, int amt, int[] coins, int[][] dp) {
        if (idx == 0) {
            if (amt % coins[idx] == 0)
                return 1;
            if (amt == coins[idx] || amt == 0)
                return 1;
            return 0;
        }
        if (dp[idx][amt] != -1)
            return dp[idx][amt];
        int nottake = f(idx - 1, amt, coins, dp);
        int take = 0;
        if (coins[idx] <= amt) {
            take = f(idx, amt - coins[idx], coins, dp);
        }
        return dp[idx][amt] = take + nottake;
    }

    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length][amount+1];
        for (int a[] : dp)
            Arrays.fill(a, -1);
        return f(coins.length - 1, amount, coins, dp);
    }
}