class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int i = 0, j = 0;
        int n = s.length();
        int len = 0;
        int currCost = 0;
        while(j<n) {
            currCost = currCost + (int)(Math.abs((s.charAt(j) - t.charAt(j))));
            while(currCost > maxCost){
                currCost = currCost - (int)(Math.abs((s.charAt(i) - t.charAt(i))));
                i++;
            }
            len = Math.max(len, j-i+1);
            j++;
        }
        return len;

    }
}