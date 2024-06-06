class Solution {
    public int singleNonDuplicate(int[] nums) {
        int xor=0;
        for(int i : nums){
            xor ^= i;
        }
        return xor;
    }
}