// class Solution {
//     public int f(int i1, int i2, String s1, String s2, int[][] dp) {
//         if (i1 < 0 || i2 < 0)
//             return 0;
//         if (dp[i1][i2] != -1)
//             return dp[i1][i2];
//         if (s1.charAt(i1) == s2.charAt(i2))
//             return dp[i1][i2] = 0 + f(i1 - 1, i2 - 1, s1, s2, dp);
//         else
//             return dp[i1][i2] = Math.min(((int) s1.charAt(i1) + f(i1 - 1, i2, s1, s2, dp)),
//                     ((int) s2.charAt(i2) + f(i1, i2 - 1, s1, s2, dp)));

//     }

//     public int minimumDeleteSum(String word1, String word2) {
//         int n = word1.length();
//         int m = word2.length();

//         int dp[][] = new int[n][m];
//         for (int[] a : dp) {
//             Arrays.fill(a, -1);
//         }

//         return f(n - 1, m - 1, word1, word2, dp);
//     }
// }

import java.util.Arrays;

class Solution {
    // Recursive function with memoization to find minimum delete sum
    public int f(int i1, int i2, String s1, String s2, int[][] dp) {
        // Base cases
        if (i1 < 0 && i2 < 0) return 0; // Both strings are exhausted
        if (i1 < 0) return sumASCII(s2, i2); // s1 is exhausted, sum remaining ASCII values of s2
        if (i2 < 0) return sumASCII(s1, i1); // s2 is exhausted, sum remaining ASCII values of s1

        // If the value is already computed, return it
        if (dp[i1][i2] != -1)
            return dp[i1][i2];

        // If characters are the same, move both pointers
        if (s1.charAt(i1) == s2.charAt(i2))
            return dp[i1][i2] = f(i1 - 1, i2 - 1, s1, s2, dp);
        else
            return dp[i1][i2] = Math.min(
                (int) s1.charAt(i1) + f(i1 - 1, i2, s1, s2, dp), // Delete from s1
                (int) s2.charAt(i2) + f(i1, i2 - 1, s1, s2, dp)  // Delete from s2
            );
    }

    // Helper function to calculate the sum of ASCII values from 0 to end index
    private int sumASCII(String s, int end) {
        int sum = 0;
        for (int i = 0; i <= end; i++) {
            sum += (int) s.charAt(i);
        }
        return sum;
    }

    public int minimumDeleteSum(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int dp[][] = new int[n][m];
        
        // Initialize dp array with -1
        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }

        return f(n - 1, m - 1, word1, word2, dp);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String word1 = "sea";
        String word2 = "eat";
        System.out.println("Minimum Delete Sum: " + sol.minimumDeleteSum(word1, word2));
    }
}
