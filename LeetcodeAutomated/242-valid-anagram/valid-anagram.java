class Solution {

    public String sort(String s){
        char[] ch = s.toCharArray();
        Arrays.sort(ch);
        return new String(ch);
    }
    public boolean isAnagram(String s, String t) {
        return (sort(s)).equals(sort(t));
    }
}