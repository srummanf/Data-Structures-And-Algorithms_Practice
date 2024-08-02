class Solution {

    public int minSwaps(int[] nums) {
        // Count how many 1's are there in the array
        int onesCount = 0;
        for (int value : nums) {
            onesCount += value;
        }

        int n = nums.length;

        // Create an extended array of sums to handle circular array
        int[] sumArray = new int[(n << 1) + 1];
        for (int i = 0; i < (n << 1); ++i) {
            sumArray[i + 1] = sumArray[i] + nums[i % n];
        }

        int maxOnes = 0;
        for (int i = 0; i < (n << 1); ++i) {
            // Determine the end index for the range of size onesCount
            int j = i + onesCount - 1;
            if (j < (n << 1)) {
                // Compute the number of 1's in the current range and update maxOnes if necessary
                maxOnes = Math.max(maxOnes, sumArray[j + 1] - sumArray[i]);
            }
        }

        // The minimum number of swaps is the difference between total ones and the maximum ones found in any range of size onesCount
        return onesCount - maxOnes;
    }
}