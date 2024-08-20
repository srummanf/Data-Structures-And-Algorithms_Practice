// Catalan Numbers

class Solution {
    public int f(int n) {
        if (n <= 1)
            return 1;
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            ans += f(i - 1) * f(n - i);
        }
        return ans;
    }

    public int numTrees(int n) {

        return f(n);

    }
}