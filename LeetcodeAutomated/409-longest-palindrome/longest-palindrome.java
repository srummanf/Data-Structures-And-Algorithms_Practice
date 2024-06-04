import java.util.HashMap;

class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> hm = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            hm.put(ch, hm.getOrDefault(ch, 0) + 1);
        }
        
        int len = 0;
        boolean hasOdd = false;

        for (int count : hm.values()) {
            if (count % 2 == 0) {
                len += count;
            } else {
                len += count - 1;  // Add the largest even number less than or equal to the count
                hasOdd = true;     // Mark that we have at least one odd count
            }
        }
        
        if (hasOdd) {
            len += 1;  // Add one more to include one character with an odd count in the center
        }
        
        return len;
    }
}
