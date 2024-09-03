class Solution {
    public boolean f(int ind, int target, int[] arr, int[][] dp) {
        if (target == 0)
            return true;
        if (ind == 0)
            return arr[0] == target;
        if (dp[ind][target] != -1)
            return dp[ind][target] == 0 ? false : true;

        boolean notTaken = f(ind - 1, target, arr, dp);

        boolean taken = false;
        if (arr[ind] <= target)
            taken = f(ind - 1, target - arr[ind], arr, dp);

        dp[ind][target] = notTaken || taken ? 1 : 0;
        return notTaken || taken;
    }

    public boolean canPartition(int[] arr) {
        int n = arr.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }
        if(sum%2!=0) return false;
        int dp[][] = new int[n][sum / 2 + 1];
        for (int row[] : dp)
            Arrays.fill(row, -1);
        return f(n - 1, sum / 2, arr, dp);
    }
}