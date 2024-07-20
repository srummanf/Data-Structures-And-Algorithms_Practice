class Solution {
    public int minimumLength(String s) {
        int[] map = new int[26];
        int n = s.length();
        int removed = 0;
        for (int i = 0; i < n; i++) {
            int ch = s.charAt(i) - 'a';
            map[ch]++;

            if(map[ch] == 3) {
                map[ch] -= 2;
                removed += 2;
            }
        }
        return n - removed;
    }
}