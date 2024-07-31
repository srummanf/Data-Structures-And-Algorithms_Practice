class Solution {
    public int f(int idx, int remaining_width, int currentHeight, int[][] books, int shelfWidth, int[][] dp) {
        if (idx >= books.length)
            return currentHeight;

        int thickness = books[idx][0];
        int height = books[idx][1];

        if (dp[idx][remaining_width] != -1)
            return dp[idx][remaining_width];
        int take = Integer.MAX_VALUE;
        if (thickness <= remaining_width) {
            take = f(idx + 1, remaining_width - thickness, Math.max(currentHeight, height), books, shelfWidth, dp);
        }
        int nottake = currentHeight + f(idx + 1, shelfWidth - thickness, height, books, shelfWidth, dp);

        return dp[idx][remaining_width] = Math.min(take, nottake);
    }

    public int minHeightShelves(int[][] books, int shelfWidth) {
        // dp[idx][remaining_width] -> we are looking only in idx and width so dont take thickness or height
        int[][] dp = new int[1001][10001];
        for (int[] a : dp)
            Arrays.fill(a, -1);
        return f(0, shelfWidth, 0, books, shelfWidth, dp);
    }
}
