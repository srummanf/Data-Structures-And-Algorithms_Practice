import java.util.*;

class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        HashMap<String, Integer> wordCount = new HashMap<>();
        StringTokenizer st = new StringTokenizer(s1);
        while (st.hasMoreTokens()) {
            String word = st.nextToken();
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        st = new StringTokenizer(s2);
        while (st.hasMoreTokens()) {
            String word = st.nextToken();
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        
        ArrayList<String> curr = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            if (entry.getValue() == 1) {
                curr.add(entry.getKey());
            }
        }
        
        String[] ans = curr.toArray(new String[0]);
        return ans;
    }
}
