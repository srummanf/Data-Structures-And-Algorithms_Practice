// Same as Subarray with atmost 2 zeroes

class Solution {
    public int longestOnes(int[] nums, int k) {
        int maxi = 0;
        int c = 0;
        int n = nums.length;
        int l = 0, r = 0;
        while (r < n) {
if (nums[r] == 0) {
                c++;
            }
            while (c > k) {
                if (nums[l] == 0)
                    c--;
                l++;
            }

            
            maxi = Math.max(maxi, r - l + 1);
            r++;
        }
        return maxi;
    }
}