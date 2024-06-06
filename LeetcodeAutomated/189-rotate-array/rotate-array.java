class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int[] copy = new int[n];
        for (int i = 0; i < n; i++) {
            copy[i] = nums[i];
        }
        for (int i = 0; i < n; i++) {
            nums[(k + i) % n] = copy[i];
        }

    }
}