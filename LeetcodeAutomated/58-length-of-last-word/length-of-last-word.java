import java.util.*;
class Solution {
    public int lengthOfLastWord(String s) {
        StringTokenizer st = new StringTokenizer(s);
        int l= 0;
        int c = st.countTokens();
        for(int i=0;i<c;i++){
            String w = st.nextToken();
             l = w.length();
        }
        return l;
    }
}