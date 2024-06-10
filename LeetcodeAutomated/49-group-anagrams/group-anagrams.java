class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] ch = new char[26];
            for (char c : s.toCharArray()) {
                ch[c - 'a']++;
            }
            String key = new String(ch);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(s);
        }
        return new ArrayList<>(map.values());
    }
}




















/**
O(N^2) SOLUTION
  |
  |
  |
  v
*/

// class Solution {
//     public String sort(String s) {
//         char ch[] = s.toCharArray();
//         Arrays.sort(ch);
//         return new String(ch);
//     }

//     public boolean isAnagram(String s, String t) {
//         String ss = sort(s);
//         String tt = sort(t);
//         return ss.equals(tt);
//     }

//     public List<List<String>> groupAnagrams(String[] strs) {
//         List<List<String>> ans = new ArrayList<>();
//         int n = strs.length;
//         for (int i = 0; i < n; i++) {
//             List<String> temp = new ArrayList<>();
//             if (!strs[i].equals("Xaa")) {
//                 temp.add(strs[i]);
//                 //System.out.println(strs[i] + "--");
//                 for (int j = i + 1; j < n; j++) {

//                     if (isAnagram(strs[i], strs[j])) {
//                         //System.out.println(isAnagram(strs[i], strs[j]));
//                         temp.add(strs[j]);
//                         strs[j] = "Xaa";
//                     }
//                     //System.out.println(temp + "---[[[");
//                 }
//                 if (temp.size() > 0) {
//                     ans.add(temp);
//                 }
//             }
//         }

//         return ans;
//     }
// }