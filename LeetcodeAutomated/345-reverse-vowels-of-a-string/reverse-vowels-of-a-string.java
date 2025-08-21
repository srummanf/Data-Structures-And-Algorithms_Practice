import java.util.*;

class Solution {
    Set<Character> vowels = new HashSet<>(Arrays.asList(
        'a','e','i','o','u',
        'A','E','I','O','U'
    ));

    // Swap helper for char array
    private void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public String reverseVowels(String s) {
        char[] charArray = s.toCharArray();
        int l = 0, r = charArray.length - 1;

        while (l < r) {
            if (!vowels.contains(charArray[l])) {
                l++;
            } else if (!vowels.contains(charArray[r])) {
                r--;
            } else {
                swap(charArray, l, r);
                l++;
                r--;
            }
        }

        return new String(charArray);
    }
}


/**
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

 */