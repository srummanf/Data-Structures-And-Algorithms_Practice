import java.util.HashMap;

class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        // Create a HashMap to store the remainder and the corresponding index
        HashMap<Integer, Integer> remainderMap = new HashMap<>();
        // Initialize the HashMap with a remainder of 0 at index -1
        remainderMap.put(0, -1);

        // Variable to store the running sum of elements
        int runningSum = 0;

        // Iterate over the array
        for (int i = 0; i < nums.length; i++) {
            runningSum += nums[i];

            // Calculate the remainder of runningSum when divided by k
            int remainder = runningSum % k;

            // If the remainder is negative, convert it to a positive remainder
            if (remainder < 0) {
                remainder += k;
            }

            // Check if this remainder has been seen before
            if (remainderMap.containsKey(remainder)) {
                // If the previous occurrence of this remainder was at least two indices back
                if (i - remainderMap.get(remainder) > 1) {
                    return true;
                }
            } else {
                // Store the current index for this remainder
                remainderMap.put(remainder, i);
            }
        }

        // If no subarray is found, return false
        return false;
    }
}
