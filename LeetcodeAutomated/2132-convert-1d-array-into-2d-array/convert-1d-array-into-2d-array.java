class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        int idx = 0;
        int[][] ans = new int[m][n];
        int[][] ans2 = new int[0][];
        if (m * n != original.length)
            return ans2;
        int r = 0, c = 0;
        for (int i : original) {
            ans[r][c++] = i;
            if (c == n) {
                c = 0;
                r++;
            }
        }

        return ans;
    }
}

/**
 * 
 * class Solution {
 * public int[][] construct2DArray(int[] original, int m, int n) {
 * int idx = 0;
 * int[][] ans = new int[m][n];
 * int[][] ans2 = new int[0][];
 * if(m*n != original.length) return ans2;
 * for (int i = 0; i < m; i++) {
 * for (int j = 0; j < n; j++) {
 * ans[i][j] = original[idx++];
 * }
 * }
 * 
 * return ans;
 * 
 * }
 * }
 * 
 */