import java.util.*;

public class SScontainingChars {
    public static int countSubstringsWithABC(String s) {
        int n = s.length();
        int[] freq = new int[3]; // Frequency count of a, b, and c
        int totalSubstrings = 0;
        int left = 0;

        for (int right = 0; right < n; right++) {
            // Update frequency count for the current character
            freq[s.charAt(right) - 'a']++;

            // Check if all three characters are present
            while (freq[0] > 0 && freq[1] > 0 && freq[2] > 0) {
                // Update the answer
                totalSubstrings += n - right;

                // Move the left pointer to the right
                freq[s.charAt(left) - 'a']--;
                left++;
            }
        }

        return totalSubstrings;
    }

    public static void main(String[] args) {
        String inputString = "abcabc";
        int result = countSubstringsWithABC(inputString);
        System.out.println("Number of valid substrings: " + result);
    }
}
