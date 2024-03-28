class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int l = 0;
        int result = 0;
        HashMap<Integer, Integer> m = new HashMap<>();
        
        for(int r = 0; r<nums.length; r++){
            m.put(nums[r], m.getOrDefault(nums[r],0)+1);
            while(m.get(nums[r])>k){
                m.put(nums[l], m.get(nums[l])-1);
                l++;
            }
            result = Math.max(result, r-l+1);

        }
        return result;
        
    }
}