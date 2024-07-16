import java.util.Arrays;

public class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);

        // Case 1: Rob houses from 0 to n-2 (exclude last house)
        int max1 = robLinear(Arrays.copyOfRange(nums, 0, nums.length - 1));
        // Case 2: Rob houses from 1 to n-1 (exclude first house)
        int max2 = robLinear(Arrays.copyOfRange(nums, 1, nums.length));

        return Math.max(max1, max2);
    }

    private int robLinear(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        
        int prev1 = 0; // Represents robbing i-2 houses
        int prev2 = 0; // Represents robbing i-1 houses
        
        for (int num : nums) {
            int temp = prev1;
            prev1 = Math.max(prev1, prev2 + num);
            prev2 = temp;
        }
        
        return prev1;
    }
}
