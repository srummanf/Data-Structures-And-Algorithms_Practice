// Game Theory -- Remember when you play the answer should be maximised and when you opponent plays the answer should be minimum 
/** Alice - 1 , Bob - 0 */

// Recursive Solution
/**
 * public int solve(int player, int idx, int M, int[] piles) {
 * if (idx >= piles.length)
 * return 0;
 * int score = 0;
 * int result = player == 1 ? -1 : Integer.MAX_VALUE;
 * for (int X = 1; X <= Math.min(2 * M, piles.length - idx); X++) {
 * score += piles[idx + X - 1];
 * if (player == 1) {
 * result = Math.max(result, score + solve(0, idx + X, Math.max(M, X), piles));
 * } else {
 * result = Math.min(result, 0 + solve(1, idx + X, Math.max(M, X), piles));
 * }
 * }
 * 
 * return result;
 * }
 * 
 * public int stoneGameII(int[] piles) {
 * return solve(1, 0, 1, piles);
 * }
 */
class Solution {
    public int solve(int player, int idx, int M, int[] piles, int[][][] dp) {
        if (idx >= piles.length)
            return 0;
        if(dp[player][idx][M] != -1) return dp[player][idx][M];
        int score = 0;
        int result = player == 1 ? -1 : Integer.MAX_VALUE;
        for (int X = 1; X <= Math.min(2 * M, piles.length - idx); X++) {
            score += piles[idx + X - 1];
            if (player == 1) {
                dp[player][idx][M] = Math.max(result, score + solve(0, idx + X, Math.max(M, X), piles, dp));
                result = dp[player][idx][M];
            } else {
                dp[player][idx][M] = Math.min(result, 0 + solve(1, idx + X, Math.max(M, X), piles, dp));
                result = dp[player][idx][M];
            }
        }

        return result;
    }

    public int stoneGameII(int[] piles) {
        int[][][] dp = new int[2][101][101];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 101; j++) {
                for (int k = 0; k < 101; k++) {
                    dp[i][j][k] = -1;
                }

            }
        }
        return solve(1, 0, 1, piles, dp);
    }
}