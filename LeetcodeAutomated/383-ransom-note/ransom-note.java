class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> hm = new HashMap<>();
        for (char ch : ransomNote.toCharArray()) {
            hm.put(ch, hm.getOrDefault(ch, 0) + 1);
        }
        // for(char ch: magazine.toCharArray()){
        // if(hm.containsKey(ch)){
        // hm.put(ch, hm.get(ch)-1);
        // }
        // if(hm.size()==0) return true;
        // }

        for (char ch : magazine.toCharArray()) {
            if (hm.containsKey(ch)) {
                int newCount = hm.get(ch) - 1;
                if (newCount == 0) {
                    hm.remove(ch);
                } else {
                    hm.put(ch, newCount);
                }
            }

            // If the HashMap is empty, all characters have been matched
            if (hm.isEmpty()) {
                return true;
            }
        }
        return false;

    }
}