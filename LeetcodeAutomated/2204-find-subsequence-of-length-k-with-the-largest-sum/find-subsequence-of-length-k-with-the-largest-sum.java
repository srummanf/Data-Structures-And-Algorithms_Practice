class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        // Initialize an array 'ans' to store the result subsequence of length k
        int[] ans = new int[k];
      
        // Create a list 'indices' to keep track of the original indices of the array elements
        List<Integer> indices = new ArrayList<>();
      
        // Loop to fill 'indices' with the array indices
        for (int i = 0; i < nums.length; ++i) {
            indices.add(i);
        }
      
        // Sort 'indices' based on the values in 'nums' from highest to lowest
        indices.sort((i1, i2) -> Integer.compare(nums[i2], nums[i1]));
      
        // Initialize a temporary array 'topIndices' to store the first k sorted indices
        int[] topIndices = new int[k];
        for (int i = 0; i < k; ++i) {
            topIndices[i] = indices.get(i);
        }
      
        // Sort 'topIndices' to maintain the original order of selected k elements
        Arrays.sort(topIndices);
      
        // Fill the 'ans' array with the elements corresponding to the sorted indices
        for (int i = 0; i < k; ++i) {
            ans[i] = nums[topIndices[i]];
        }
      
        // Return the result array containing the max subsequence of length k
        return ans;
    }
}