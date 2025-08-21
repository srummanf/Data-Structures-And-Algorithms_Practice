import java.util.*;

class Solution {
    public String reverseVowels(String s) {
        Stack<Character> st = new Stack<>();
        Set<Character> vowels = new HashSet<>(Arrays.asList(
            'a','e','i','o','u',
            'A','E','I','O','U'
        ));

        // Collect vowels into stack
        for (char ch : s.toCharArray()) {
            if (vowels.contains(ch)) {
                st.push(ch);
            }
        }

        // Build answer with reversed vowels
        StringBuilder ans = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (vowels.contains(ch)) {
                ans.append(st.pop());
            } else {
                ans.append(ch);
            }
        }

        return ans.toString();
    }
}
