class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        int cnt = 0;
        HashSet<Character> a = new HashSet<>();
        for (char ch : allowed.toCharArray()) {
            a.add(ch);
        }
        for (String word : words) {
            int flag = 0;
            HashSet<Character> b = new HashSet<>();
            for (char ch : word.toCharArray()) {
                if (a.contains(ch) == false) {
                    flag = 1;
                    continue;
                }
            }
            if (flag == 0)
                cnt++;
        }
        return cnt;

    }
}