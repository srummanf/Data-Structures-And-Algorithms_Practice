class Solution {
    public boolean canAliceWin(int[] nums) {
        int sumA = 0;
        int sumB = 0;
        for (int i : nums) {
            if (i < 10)
                sumA += i;
            else
                sumB += i;
        }
        if (sumA == sumB)
            return false;
        return true;
    }
}