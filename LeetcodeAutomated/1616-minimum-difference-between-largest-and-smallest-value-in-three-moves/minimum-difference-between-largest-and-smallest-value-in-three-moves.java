class Solution {
    public int minDifference(int[] nums) {
        // Get the length of the nums array
        int length = nums.length;
      
        // If there are less than 5 elements, return 0 since we can remove all but 4 elements
        if (length < 5) {
            return 0;
        }
      
        // Sort the array to make it easier to find the minimum difference
        Arrays.sort(nums);
      
        // Initialize the minimum difference to a very large value
        long minDiff = Long.MAX_VALUE;
      
        // Loop through the array and consider removing 0 to 3 elements from the beginning 
        // and the rest from the end to minimize the difference
        for (int left = 0; left <= 3; ++left) {
            int right = 3 - left;
            // Calculate the difference between the selected elements
            long diff = (long)nums[length - 1 - right] - nums[left];
            // Update the minimum difference if the current one is smaller
            minDiff = Math.min(minDiff, diff);
        }
      
        // Return the minimum difference as an integer
        return (int) minDiff;
    }
}