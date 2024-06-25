class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> hm = new HashMap<>();
        int l = 0, r = 0;
        int n = s.length();
        int maxi = 0;
        while (r < n) {
            char currentChar = s.charAt(r);
        
            if (hm.containsKey(currentChar)) {
                l = Math.max(hm.get(currentChar) + 1, l);
            }
            
            hm.put(currentChar, r);
            
            maxi = Math.max(maxi, r - l + 1);
            
            r++;
        }

        return maxi;

    }
}