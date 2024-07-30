import java.util.Arrays;

public class Solution {
    public int bestTeamScore(int[] scores, int[] ages) {
        int n = scores.length;
        int[][] players = new int[n][2];

        // Combine scores and ages into a single array of players
        for (int i = 0; i < n; i++) {
            players[i][0] = ages[i];
            players[i][1] = scores[i];
        }

        // Sort the players array: first by age, then by score
        Arrays.sort(players, (a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(a[1], b[1]);
            } else {
                return Integer.compare(a[0], b[0]);
            }
        });

        // dp[i] will store the maximum score we can get by including the ith player
        int[] dp = new int[n];
        int maxScore = 0;

        // Initialize the dp array with the scores of each player
        for (int i = 0; i < n; i++) {
            dp[i] = players[i][1];
        }

        // Fill the dp array with the maximum scores possible
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                // Check if we can include the ith player in the team with jth player
                if (players[i][1] >= players[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + players[i][1]);
                }
            }
            maxScore = Math.max(maxScore, dp[i]);
        }

        return maxScore;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] scores = {4, 5, 6, 5};
        int[] ages = {2, 1, 2, 1};
        System.out.println("Best Team Score: " + sol.bestTeamScore(scores, ages)); // Expected: 16

        int[] scores2 = {1, 3, 5, 10, 15};
        int[] ages2 = {1, 2, 3, 4, 5};
        System.out.println("Best Team Score: " + sol.bestTeamScore(scores2, ages2)); // Expected: 34

        int[] scores3 = {1, 2, 3, 5};
        int[] ages3 = {8, 9, 10, 1};
        System.out.println("Best Team Score: " + sol.bestTeamScore(scores3, ages3)); // Expected: 6
    }
}
