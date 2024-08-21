class Solution {
    public int strangePrinter(String s) {
        int[][] dp = new int[101][101];
        for (int i = 0; i < 101; i++) {
            Arrays.fill(dp[i], 1);
        }

        int n = s.length();
        if (n == 0) {
            return 0;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                dp[j][j + i] = i + 1;

                for (int k = j + 1; k <= j + i; k++) {
                    int temp = dp[j][k - 1] + dp[k][j + i];
                    if (s.charAt(k - 1) == s.charAt(j + i)) {
                        temp--;
                    }
                    dp[j][j + i] = Math.min(temp, dp[j][j + i]);
                }
            }
        }
        return dp[0][n - 1];
    }
}