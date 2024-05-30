class Solution {

    public static int DP_topdown(int idx, int target, int[] arr, int[][] dp){
        if(idx == 0){
            if(target % arr[0] == 0) return target/arr[0];
            else return (int) Math.pow(10,9);
        }
        if(dp[idx][target] != -1) return dp[idx][target];

        int nottake =  0 + DP_topdown(idx-1, target, arr, dp);
        int take = (int) Math.pow(10,9);
        if(arr[idx]<= target){
            take = 1 + DP_topdown(idx, target - arr[idx], arr, dp);
        }
        return dp[idx][target] = Math.min(take, nottake);
    }
    public int coinChange(int[] arr, int t) {

        int[][] dp = new int[arr.length][t + 1];
    for (int row[] : dp) java.util.Arrays.fill(row, -1);
        
        return DP_topdown(arr.length - 1, t, arr, dp) == (int) Math.pow(10, 9)
        ? -1
        : DP_topdown(arr.length - 1, t, arr, dp);
    }
}