class Solution {
    /**
     * This method finds the special number x in the given array nums.
     * An array nums is considered special if there exists a number x 
     * such that there are exactly x numbers in nums that are greater 
     * than or equal to x.
     *
     * @param nums An array of non-negative integers.
     * @return The special number x if it exists, otherwise -1.
     */
    public int specialArray(int[] nums) {
        // Iterate through potential values of x from 0 to the length of nums
        for(int i = 0; i <= nums.length; i++) {
            int count = 0; // Counter to keep track of numbers >= i
            
            // Count how many numbers in nums are greater than or equal to i
            for(int j = 0; j < nums.length; j++) {
                if(nums[j] >= i) {
                    count++;
                }
            }
            
            // Check if the current i value matches the count of numbers >= i
            if(i == count) {
                return i; // Return i if it is the special number
            }
        }
        
        // Return -1 if no special number is found
        return -1;
    }
}
