class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        int k = 0;
        for (int i : arr) {
            if (i % 2 == 1)
                k++;
            if (k == 3)
                return true;
            if (i % 2 == 0)
                k = 0;
        }
        return false;

    }
}