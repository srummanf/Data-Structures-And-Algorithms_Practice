class Solution {
    public int removeElement(int[] nums, int val) {
        int count = 0, pos=0;
        int ans[] = new int[nums.length];
        for(int i=0; i<nums.length; i++){
            if(nums[i]!=val){
                count++;
                ans[pos++] = nums[i];
            }
        }
        System.out.println(Arrays.toString(ans));
        for (int i = 0; i < nums.length; i++) {
            nums[i] = ans[i];
        }
        return count;

    }
}