import java.util.*;  

class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        HashSet<String> h = new HashSet<>();
        for (String w : dictionary) {
            h.add(w);
        }
        String ans = "";
        int flag = 0;
        StringTokenizer st = new StringTokenizer(sentence, " ");
        while (st.hasMoreTokens()) {
            String temp = "";
            String word = st.nextToken();
            
            for (int i = 0; i < word.length(); i++) {
                String sub = word.substring(0, i + 1);
                if (h.contains(sub)) {
                    ans = ans + sub;
                    flag = 1;
                    break;
                }
            }
            if (flag == 0) {
                ans = ans + word;
            }
            ans=ans+ " ";
            flag=0;
        }

        return ans.trim();

    }
}


/**
import java.util.*;

class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        // Convert the dictionary list to a set for faster lookup
        Set<String> dictSet = new HashSet<>(dictionary);
        
        // Split the sentence into words
        String[] words = sentence.split(" ");
        
        // StringBuilder to construct the result sentence
        StringBuilder result = new StringBuilder();
        
        // Iterate over each word in the sentence
        for (String word : words) {
            String replacement = word; // Default to the word itself
            // Check each prefix of the word
            for (int i = 1; i <= word.length(); i++) {
                String prefix = word.substring(0, i);
                if (dictSet.contains(prefix)) {
                    replacement = prefix;
                    break;
                }
            }
            // Append the replacement to the result
            result.append(replacement).append(" ");
        }
        
        // Remove the trailing space and return the result
        return result.toString().trim();
    }
}
 */