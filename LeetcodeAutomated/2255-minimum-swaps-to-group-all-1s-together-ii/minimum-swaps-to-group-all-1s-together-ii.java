class Solution {
    public int minSwaps(int[] nums) {
        int ones = 0;
        for (int i : nums)
            ones += i;
        int maxOnes = 0;
        int l = 0;
        int n = nums.length;
        int windowOnes = 0;
        for (int r = 0; r < 2*n; r++) {
            if (nums[r % n] == 1)
                windowOnes++;
            if (r - l + 1 > ones) {
                windowOnes -= nums[l % n];
                l = l + 1;
            }
            maxOnes = Math.max(maxOnes, windowOnes);
        }
        return ones - maxOnes;
    }
}