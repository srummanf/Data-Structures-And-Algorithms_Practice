class Solution {
    public int search(int[] nums, int k) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;

            // if mid points to the target
            if (nums[mid] == k)
                return mid;

            // if left part is sorted
            if (nums[low] <= nums[mid]) {
                if (nums[low] <= k && k <= nums[mid]) {
                    // element exists
                    high = mid - 1;
                } else {
                    // element does not exist
                    low = mid + 1;
                }
            } else { // if right part is sorted
                if (nums[mid] <= k && k <= nums[high]) {
                    // element exists
                    low = mid + 1;
                } else {
                    // element does not exist
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}