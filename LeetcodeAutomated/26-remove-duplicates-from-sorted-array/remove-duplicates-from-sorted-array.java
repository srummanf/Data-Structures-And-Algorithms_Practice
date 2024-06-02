class Solution {
    public int removeDuplicates(int[] nums) {
        // HashSet<Integer> hm = new HashSet<>();
        int n = nums.length;
        if (n == 0)
            return 0;

        int i = 0;

        for (int j = 1; j < n; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;

    }
}
