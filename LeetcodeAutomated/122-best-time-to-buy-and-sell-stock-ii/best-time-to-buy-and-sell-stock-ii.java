class Solution {
    static int profit = 0;
    public static int f(int idx, int buy, int[] val, int[][] dp){

        if(idx == val.length) return 0;
        if(dp[idx][buy] != -1) return dp[idx][buy];
        if(buy==1){
            profit = Math.max((-val[idx] + f(idx+1, 0, val, dp)),(0 + f(idx+1, 1, val, dp)) );
        } else {
            profit = Math.max((val[idx] + f(idx+1, 1, val, dp)),(0 + f(idx+1, 0, val, dp)) );
        }

        return dp[idx][buy] = profit;

    }

    // public static int f_tab(int[] val){
    //     int n = prices.length;
    //     int[][] dp = new int [n+1][2];

    //     // Write for Base Case 
    //     for(int i=0; i<=1; i++){
    //         dp[n][i] = 0;
    //     }

    //     // Copy the memoization and use loops
    //     // if(buy==1){
    //     //     profit = Math.max((-val[idx] + f(idx+1, 0, val)),(0 + f(idx+1, 1, val)) );
    //     // } else {
    //     //     profit = Math.max((val[idx] + f(idx+1, 1, val)),(0 + f(idx+1, 0, val)) );
    //     // }

    //     // return profit;

    //     for(int idx = n-1; idx>=0 ; idx--){
    //         for(int buy=0; buy<=1; buy++)
    //     }
    // }
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for(int[] a : dp){
            Arrays.fill(a, -1);
        }

        return f(0, 1, prices, dp );
    }
}