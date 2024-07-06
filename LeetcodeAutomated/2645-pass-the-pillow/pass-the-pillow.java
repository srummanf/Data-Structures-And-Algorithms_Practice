class Solution {
    public int passThePillow(int n, int k) {
        k = k % (2 * (n - 1));
        if (k <= n - 1) {
            return k + 1;
        } else {
            return 2 * (n - 1) - k + 1;
        }
    }
}