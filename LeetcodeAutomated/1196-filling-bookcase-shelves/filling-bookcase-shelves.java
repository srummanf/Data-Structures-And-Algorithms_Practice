class Solution {
    public int f(int idx, int remaining_width, int currentHeight, int[][] books, int shelfWidth, int[][] dp) {
        if (idx >= books.length)
            return currentHeight;

        int thickness = books[idx][0];
        int height = books[idx][1];

        if (dp[idx][remaining_width] != -1)
            return dp[idx][remaining_width];

        // Option 1: Place the current book on the current shelf if it fits
        int take = Integer.MAX_VALUE;
        if (thickness <= remaining_width) {
            take = f(idx + 1, remaining_width - thickness, Math.max(currentHeight, height), books, shelfWidth, dp);
        }

        // Option 2: Start a new shelf with the current book
        int nottake = currentHeight + f(idx + 1, shelfWidth - thickness, height, books, shelfWidth, dp);

        return dp[idx][remaining_width] = Math.min(take, nottake);
    }

    public int minHeightShelves(int[][] books, int shelfWidth) {
        int[][] dp = new int[1001][10001];
        for (int[] a : dp)
            Arrays.fill(a, -1);
        return f(0, shelfWidth, 0, books, shelfWidth, dp);
    }
}
