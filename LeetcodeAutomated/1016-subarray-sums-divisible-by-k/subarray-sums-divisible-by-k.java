class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        // Create a hashmap to store the frequencies of prefix sum remainders.
        Map<Integer, Integer> countMap = new HashMap<>();
        // Initialize with remainder 0 having frequency 1.
        countMap.put(0, 1);
      
        // 'answer' will keep the total count of subarrays divisible by k.
        int answer = 0;
        // 'sum' will store the cumulative sum.
        int sum = 0;
      
        // Loop through all numbers in the array.
        for (int num : nums) {
            // Update the cumulative sum and adjust it to always be positive and within the range of [0, k-1]
            sum = ((sum + num) % k + k) % k;
            // If this remainder has been seen before, add the number of times it has been seen to the answer.
            answer += countMap.getOrDefault(sum, 0);
            // Increase the frequency of this remainder by 1.
            countMap.merge(sum, 1, Integer::sum);
        }
      
        // Return the total count of subarrays that are divisible by 'k'.
        return answer;
    }
}