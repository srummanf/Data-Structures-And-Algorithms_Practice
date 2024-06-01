//Day 7

// https://leetcode.com/problems/longest-string-chain/description/

import java.util.Arrays;
import java.util.Comparator;

public class dp_45_LongestStringSequence {

    // Arranging the array based on ascending length of the string length
    public static String[] sortStringsByLength(String[] inputArray) {
        String[] sortedArray = Arrays.copyOf(inputArray, inputArray.length);
        Arrays.sort(sortedArray, Comparator.comparingInt(String::length));
        return sortedArray;
    }

    // Comparing two strings --> 2 pointer Appraoch
    boolean compare(String s1, String s2) {
        if (s1.length() != s2.length() + 1)
            return false;

        int first = 0;
        int second = 0;

        while (first < s1.length()) {
            if (second < s2.length() && (s1.charAt(first) == s2.charAt(second))) {
                first++;
                second++;
            } else
                first++;
        }
        if (first == s1.length() && second == s2.length())
            return true;
        else
            return false;
    }

    // Tabulation DP
    public int longestStrChain(String[] words) {
        int n = words.length;
        int maxi = 1;

        String[] arr = sortStringsByLength(words);

        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for (int i = 0; i <= n - 1; i++) {

            for (int prev_index = 0; prev_index <= i - 1; prev_index++) {

                if (compare(arr[i], arr[prev_index]) && (1 + dp[prev_index] > dp[i])) {
                    dp[i] = 1 + dp[prev_index];
                }
            }

            if (dp[i] > maxi)
                maxi = dp[i];
        }
        return maxi;
    }
}
