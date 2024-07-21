#include <vector>
#include <unordered_map>
#include <algorithm>
#include <climits>

using namespace std;

class Solution {
public:
    int minChanges(vector<int>& nums, int k) {
        int n = nums.size();
        unordered_map<int, int> curDiffCount;
        vector<int> oneOp(k + 1, 0);
        
        // Count the differences and how often each difference occurs
        for (int i = 0; i < n / 2; ++i) {
            int diff = abs(nums[i] - nums[n - i - 1]);
            curDiffCount[diff]++;
        
        
        // Calculate the maximum achievable difference with one operation
        int minEl = min(nums[i], nums[n - i - 1]);
        int maxEl = max(nums[i], nums[n - i - 1]);
        int maxAchievableDiff = max(k - minEl, maxEl - 0);
        oneOp[maxAchievableDiff]++;
        }
        
        // Calculate achievable differences with one operation
        for (int maxAchievableDiff = k - 1; maxAchievableDiff >= 0; --maxAchievableDiff) {
            oneOp[maxAchievableDiff] += oneOp[maxAchievableDiff + 1];
        }
        
        // Find the minimum number of changes required
        int ans = INT_MAX;
        for (const auto& [diff, count] : curDiffCount) {
            int oneExtra = oneOp[diff] - count;
            int two = n / 2 - oneExtra - count;
            ans = min(ans, oneExtra + two * 2);
        }
        
        return ans;
    }
};

