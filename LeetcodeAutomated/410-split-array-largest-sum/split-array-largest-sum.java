class Solution {
    public int sumVal(int[] nums) {
        int maxi = 0;
        for (int i : nums) {
            maxi += i;
        }
        return maxi;
    }

    public int maxVal(int[] nums) {
        int maxi = 0;
        for (int i : nums) {
            maxi = Math.max(maxi, i);
        }
        return maxi;
    }

    public int PossibleNumberOfStudents(int[] nums, int maxPages) {
        int students = 0;
        int pages = 0;
        for (int i = 0; i < nums.length; i++)
            if (pages + nums[i] <= maxPages)
                pages += nums[i];
            else {
                students++;
                pages = nums[i];
            }
        return students;
    }

    public int splitArray(int[] nums, int k) {

        int maxval = maxVal(nums);
        int sumval = sumVal(nums);
        int low = maxval;
        int high = sumval;

        while (low <= high) {
            int mid = (low + high) / 2;
            int noOfStudents = PossibleNumberOfStudents(nums, mid);
            if (noOfStudents >= k)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return low;

    }
}