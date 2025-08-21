class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = 0;
        int maxLen = 0;
        HashMap<Character, Integer> hm = new HashMap<>();

        for (int r = 0; r < s.length(); r++) {
            if(hm.containsKey(s.charAt(r))){
                l = Math.max(l, (hm.get(s.charAt(r)))+1);
            }
            hm.put(s.charAt(r), r);
            maxLen = Math.max(maxLen, (r-l+1));
        }
        return maxLen;
    }
}