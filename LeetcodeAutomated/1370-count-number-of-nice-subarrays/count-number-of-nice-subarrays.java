class Solution {
    public boolean isOdd(int n) {
        return n % 2 != 0;
    }

    public int numberOfSubarrays(int[] nums, int k) {
        return atMostK(nums, k) - atMostK(nums, k - 1);
    }

    private int atMostK(int[] nums, int k) {
        int count = 0;
        int start = 0;
        int oddCount = 0;

        for (int end = 0; end < nums.length; end++) {
            if (isOdd(nums[end])) {
                oddCount++;
            }

            while (oddCount > k) {
                if (isOdd(nums[start])) {
                    oddCount--;
                }
                start++;
            }

            count += end - start + 1;
        }

        return count;
    }

}