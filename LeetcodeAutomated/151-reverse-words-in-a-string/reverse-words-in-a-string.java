import java.util.*;

class Solution {
    public String reverseWords(String s) {
        StringTokenizer st = new StringTokenizer(s);
        int len = st.countTokens();
        String ans = "";
        while (len > 0) {
            ans = st.nextToken() + " " + ans;
            len--;
        }
        return ans.trim();

    }
}