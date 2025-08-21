class Solution {
    public int longestOnes(int[] nums, int k) {
        int maxLen = 0;
        int l = 0;
        int count = 0;
        for(int r = 0; r<nums.length; r++){
            if(nums[r] == 0) count++;
            while(count>k){
                if(nums[l]==0) count--;
                l++;
            }
            maxLen = Math.max(maxLen, (r-l+1));
        }


        return maxLen;
        
    }
}