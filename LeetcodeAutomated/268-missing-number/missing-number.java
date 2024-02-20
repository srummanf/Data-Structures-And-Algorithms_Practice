class Solution {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        if(nums[0] != 0){
            return 0;
        }
        System.out.println(Arrays.toString(nums));
            for(int i=0; i<nums.length-1; i++){
                if(nums[i]!=0 && i==0){
                    return 0;
                }
                if((nums[i+1]-nums[i])!=1){
                    return i+1;
                }
            }
            return nums.length;
        
        
    }
}