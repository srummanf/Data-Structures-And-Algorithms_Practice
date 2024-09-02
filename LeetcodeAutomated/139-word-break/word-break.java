
class Solution {
    public boolean dfs(String s, HashSet<String> hash, HashMap<String, Boolean> dp) {
        // If we have already computed the result for the current string, return it
        if (dp.containsKey(s)) {
            return dp.get(s);
        }
        
        // If the entire string is in the dictionary, we can segment it directly
        if (hash.contains(s)) {
            dp.put(s, true);
            return true;
        }
        
        int n = s.length();
        // Try to split the string into two parts: prefix and suffix
        for (int i = 1; i < n; i++) {
            String prefix = s.substring(0, i);
            String suffix = s.substring(i);
            // Check if the prefix is in the dictionary and if the suffix can be segmented
            if ((hash.contains(prefix) && hash.contains(suffix)) || (hash.contains(prefix) && dfs(suffix, hash, dp))) {
                dp.put(s, true);
                return true;
            }
        }
        
        // If no valid segmentation is found, store and return false
        dp.put(s, false);
        return false;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> hash = new HashSet<>(wordDict);
        HashMap<String, Boolean> dp = new HashMap<>();
        
        // Start DFS from the full string
        return dfs(s, hash, dp);
    }
}
// class Solution {
//     public boolean dfs(String s, HashSet<String> hash,HashMap<String, Boolean> dp) {
//         int n = s.length();
//         for (int i = 1; i < n; i++) {
//             String prefix = s.substring(0, i);
//             String suffix = s.substring(i);
//             if ((hash.contains(prefix) && hash.contains(suffix)) || (hash.contains(prefix) && dfs(suffix, hash, dp)))
//                {
//                     dp.put(s, true);
//                     return dp.get(s);
//                 }
//         }
//         dp.put(s, false);
//         return dp.get(s);
//     }

//     public boolean wordBreak(String s, List<String> wordDict) {
        
//         HashSet<String> hash = new HashSet<>(wordDict);
//         HashMap<String, Boolean> dp = new HashMap<>();
//         if(hash.contains(s)) return true;
//         return dfs(s, hash, dp);
//     }
// }