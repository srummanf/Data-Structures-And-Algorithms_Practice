class Solution {
    // Naive solution
    // public int singleNonDuplicate(int[] nums) {
    // int xor=0;
    // for(int i : nums){
    // xor ^= i;
    // }
    // return xor;
    // }

    public int singleNonDuplicate(int[] nums) {
        int low = 0;
        int high = nums.length-2;
        while(low<=high){
            int mid = (low + high) >> 1;
            if(nums[mid] == nums[mid^1]){
                low = mid+1;
            } else {
                high = mid -1;
            }

        }
        return nums[low];
    }
}