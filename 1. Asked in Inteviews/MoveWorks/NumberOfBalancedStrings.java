import java.util.Arrays;

public class Main {

    public static int numberOfBalancedStrings(int n, int d) {
        if (n <= 0 || d < 0) return 0;

        int MOD = 1000000007;
        int[][] dp = new int[n][26];

        // Initialize the first character counts
        Arrays.fill(dp[0], 1);

        // Fill the dp array
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 26; j++) {
                dp[i][j] = 0;
                for (int k = Math.max(0, j - d); k <= Math.min(25, j + d); k++) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][k]) % MOD;
                }
            }
        }

        // Sum up all the ways to form a balanced string of length n
        int result = 0;
        for (int i = 0; i < 26; i++) {
            result = (result + dp[n - 1][i]) % MOD;
        }

        return result;
    }

    public static void main(String[] args) {
        int n = 3;
        int d = 1;
        System.out.println(numberOfBalancedStrings(n, d)); // Output: Number of balanced strings
    }
}
