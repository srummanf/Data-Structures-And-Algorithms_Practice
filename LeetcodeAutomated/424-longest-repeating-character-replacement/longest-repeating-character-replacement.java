class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        HashMap<Character, Integer> hm = new HashMap<>();
        int l = 0;
        int maxlen = 0;
        int maxfreq = 0;
        
        for (int r = 0; r < n; r++) {
            char rightChar = s.charAt(r);
            hm.put(rightChar, hm.getOrDefault(rightChar, 0) + 1);
            maxfreq = Math.max(maxfreq, hm.get(rightChar));

            // Calculate the current window size
            int windowSize = r - l + 1;

            // If the current window size minus the most frequent character's frequency is greater than k,
            // shrink the window from the left
            if (windowSize - maxfreq > k) {
                char leftChar = s.charAt(l);
                hm.put(leftChar, hm.get(leftChar) - 1);
                l++;
            }

            // Update the maximum length found so far
            maxlen = Math.max(maxlen, r - l + 1);
        }
        
        return maxlen;
    }
}
