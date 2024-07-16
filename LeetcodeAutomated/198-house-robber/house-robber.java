/**
 * public int f(int idx, int[] nums){
 * if(idx<0) return 0;
 * int take = nums[idx] + f(idx-2, nums);
 * int nottake = 0 + f(idx-1, nums);
 * 
 * return Math.max(take, nottake);
 * }
 * public int rob(int[] nums) {
 * return f(nums.length-1, nums);
 * }
 */

class Solution {
    public int f(int idx, int[] nums, int[] dp) {
        if (idx < 0)
            return 0;
        if (dp[idx] != -1)
            return dp[idx];
        int take = nums[idx] + f(idx - 2, nums, dp);
        int nottake = 0 + f(idx - 1, nums, dp);

        return dp[idx] = Math.max(take, nottake);
    }

    public int rob(int[] nums) {
        int n = nums.length - 1;
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return f(nums.length - 1, nums, dp);
    }
}