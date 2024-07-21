import java.util.*;

class Solution {
    public int minChanges(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> curDiffCount = new HashMap<>();
        int[] oneOp = new int[k + 1];

        // Count the differences and how often each difference occurs
        for (int i = 0; i < n / 2; ++i) {
            int diff = Math.abs(nums[i] - nums[n - i - 1]);
            curDiffCount.put(diff, curDiffCount.getOrDefault(diff, 0) + 1);

            // Calculate the maximum achievable difference with one operation
            int minEl = Math.min(nums[i], nums[n - i - 1]);
            int maxEl = Math.max(nums[i], nums[n - i - 1]);
            int maxAchievableDiff = Math.max(k - minEl, maxEl - 0);
            oneOp[maxAchievableDiff]++;
        }

        // Calculate achievable differences with one operation
        for (int maxAchievableDiff = k - 1; maxAchievableDiff >= 0; --maxAchievableDiff) {
            oneOp[maxAchievableDiff] += oneOp[maxAchievableDiff + 1];
        }

        // Find the minimum number of changes required
        int ans = Integer.MAX_VALUE;
        for (Map.Entry<Integer, Integer> entry : curDiffCount.entrySet()) {
            int diff = entry.getKey();
            int count = entry.getValue();
            int oneExtra = oneOp[diff] - count;
            int two = n / 2 - oneExtra - count;
            ans = Math.min(ans, oneExtra + two * 2);
        }

        return ans;
    }
}