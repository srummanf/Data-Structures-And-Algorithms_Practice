class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();

        // DP table initialization
        boolean[][] dp = new boolean[n + 1][m + 1];

        // Base case: empty string and empty pattern
        dp[0][0] = true;

        // Fill the first row where s is empty
        for (int j = 1; j <= m; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 1];
            }
        }

        // Fill the DP table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (p.charAt(j - 1) == '*') {
                    // '*' can match zero or more characters
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                } else if (p.charAt(j - 1) == '?' || s.charAt(i - 1) == p.charAt(j - 1)) {
                    // '?' matches any single character or characters match
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = false;
                }
            }
        }

        return dp[n][m];
    }
}
