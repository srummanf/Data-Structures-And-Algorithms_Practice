class Solution {
    public int maxSubArray(int[] nums) {
        
        int n = nums.length;
        if(n==1) return nums[0];
        int j = 0;
        int sum = 0;
        int maxi = Integer.MIN_VALUE;
        int i = 0;
        for(i=0; i<n; i++){
            sum += nums[i];
            if(sum>maxi){
                maxi = sum;
            }
            if(sum<0) sum = 0;
        }

        return maxi;
        
    }
}