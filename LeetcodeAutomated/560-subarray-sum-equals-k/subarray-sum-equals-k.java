class Solution {
    public static int subarraySum(int[] arr, int k) {
        int n = arr.length; // size of the given array.
        Map<Integer, Integer> prefixSumMap = new HashMap<>();
        int preSum = 0, count = 0;

        prefixSumMap.put(0, 1); // Setting 0 in the map to handle subarrays starting from index 0.
        for (int i = 0; i < n; i++) {
            // Add current element to prefix Sum:
            preSum += arr[i];

            // Calculate preSum - k:
            int target = preSum - k;

            // Add the number of subarrays found to the count:
            count += prefixSumMap.getOrDefault(target, 0);

            // Update the count of prefix sum in the map:
            prefixSumMap.put(preSum, prefixSumMap.getOrDefault(preSum, 0) + 1);
        }
        return count;
    }

}
