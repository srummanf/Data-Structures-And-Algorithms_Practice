import java.util.Arrays;

class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int count = 0;
        int n = s.length;
        int m = g.length;

        int pos = 0;

        for (int i = 0; i < n; i++) {
            if (pos < m && g[pos] <= s[i]) {
                pos++;
                count++;
            }
        }

        return count;
    }


}
