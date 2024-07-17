// class Solution {
//     public boolean solve(int idx, String s, List<String> wordDict){
//         if(idx==s.length()) return true;

//         if(wordDict.contains(s)) return true;

//         for(int i = idx+1; i<=s.length(); i++){
//             if(wordDict.contains(s.substring(idx, i)) && solve(i, s, wordDict)) return true;
//         }

//         return false;
//     }
//     public boolean wordBreak(String s, List<String> wordDict) {
//         return solve(0, s, wordDict);
        
//     }
// }

class Solution {
    public boolean solve(int idx, String s, List<String> wordDict, Boolean[] memo) {
        if (idx == s.length()) return true;
        if (memo[idx] != null) return memo[idx];

        for (int i = idx + 1; i <= s.length(); i++) {
            if (wordDict.contains(s.substring(idx, i)) && solve(i, s, wordDict, memo)) {
                return memo[idx] = true;
            }
        }
        return memo[idx] = false;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        Boolean[] memo = new Boolean[s.length()];
        return solve(0, s, wordDict, memo);
    }
}
