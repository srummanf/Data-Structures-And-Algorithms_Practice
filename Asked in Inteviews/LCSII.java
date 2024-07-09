/** “You are given two strings, ‘s’ and ‘t,’ where ‘t’ is a subsequence of ‘s.’ Your task is to identify and remove the longest substring from ‘s’ such that ‘s’ still contains ‘t’ as a subsequence.”
 */

import java.util.*;

class LCSII {
    public static int ss(String s, String t) {
        int slen = s.length();
        int tlen = t.length();
        boolean[] val = new boolean[slen];
        Arrays.fill(val, false);
        int pos = 0;
        
        for (int i = 0; i < slen; i++) {
            if (s.charAt(i) == t.charAt(pos)) {
                val[i] = true;
                pos++;
            }
            if (pos == tlen) {
                break;
            }
        }
        
        if (pos < tlen) {
            return -1; // if `t` is not a subsequence of `s`
        }
        
        int maxi = 0;
        int curr = 0;
        
        for (int i = 0; i < slen; i++) {
            if (!val[i]) {
                curr++;
            } else {
                maxi = Math.max(maxi, curr);
                curr = 0; // reset curr to 0 instead of 1
            }
        }
        maxi = Math.max(maxi, curr);
        
        System.out.println(Arrays.toString(val));
        return maxi;
    }

    public static void main(String[] args) {
        String s = "abbbbbbbbbcde";
        String t = "bcd";
        System.out.println(ss(s, t)); // Output: 8
    }
}
