import java.util.*;

public class Solution {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Set<List<Integer>> uniqueQuadruplets = new HashSet<>();

        int n = nums.length;
        Arrays.sort(nums);

        for (int i = 0; i < n - 3; i++) {
            // Avoid duplicate quadruplets with the same first element
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < n - 2; j++) {
                // Avoid duplicate quadruplets with the same second element
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                int left = j + 1;
                int right = n - 1;

                while (left < right) {
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        List<Integer> quadruplet = Arrays.asList(nums[i], nums[j], nums[left], nums[right]);
                        ans.add(quadruplet);
                        // Move pointers to avoid duplicate quadruplets
                        while (left < right && nums[left] == nums[left + 1]) left++;
                        while (left < right && nums[right] == nums[right - 1]) right--;
                        left++;
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }

        return ans;
    }
}
