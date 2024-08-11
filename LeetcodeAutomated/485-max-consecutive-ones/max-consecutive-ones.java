class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int maxi = 0;
        for (int i : nums) {
            if (i == 1) {
                count++;
            } else {
                maxi = Math.max(maxi, count);
                count = 0;
            }
        }
        maxi = Math.max(maxi, count);
        return maxi;
    }
}