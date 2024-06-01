import java.math.*;

class Solution {
    public int scoreOfString(String s) {
        int sum = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            char ch1 = s.charAt(i);
            char ch2 = s.charAt(i + 1);

            int val = ch1 - ch2;
            sum += Math.abs(val);

        }
        return sum;

    }
}