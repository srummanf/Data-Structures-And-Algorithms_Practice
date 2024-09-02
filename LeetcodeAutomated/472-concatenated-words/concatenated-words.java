class Solution {
    public boolean dfs(String word, HashSet<String> hash, HashMap<String, Boolean> dp) {
        int n = word.length();
        if (dp.containsKey(word))
            return dp.get(word);
        for (int i = 1; i < n; i++) {
            String prefix = word.substring(0, i);
            String suffix = word.substring(i);
            if ((hash.contains(prefix) && hash.contains(suffix)) ||
                    (hash.contains(prefix) && dfs(suffix, hash, dp))) {
                {
                    dp.put(word, true);
                    return dp.get(word);
                }
            }
        }
        dp.put(word, false);
        return dp.get(word);
    }

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> ans = new ArrayList<>();
        HashSet<String> hash = new HashSet<>(Arrays.asList(words));
        HashMap<String, Boolean> dp = new HashMap<>();
        int n = words.length;
        for (String w : words) {
            if (dfs(w, hash, dp))
                ans.add(w);
        }
        return ans;
    }
}