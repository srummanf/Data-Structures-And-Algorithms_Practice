class Solution {
    public int minimumPushes(String word) {
        TreeMap<Character, Integer> hm = new TreeMap<>();
        for (char ch : word.toCharArray()) {
            hm.put(ch, hm.getOrDefault(ch, 0) + 1);
        }
        int n = hm.size();
        if (n <= 8) {
            return word.length();
        }
        int mul = 1;
        int count = 0;
        int ans = 0;

        List<Integer> freq = new ArrayList<>(hm.values());
        Collections.sort(freq, Collections.reverseOrder());

        for (int i = 0; i < freq.size(); i++) {
            if (count == 8) {
                mul++;
                count = 0;
            }
            ans += freq.get(i) * mul;
            count++;
        }

        

        return ans;

    }
}