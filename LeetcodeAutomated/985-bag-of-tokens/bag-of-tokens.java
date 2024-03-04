class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {

        Arrays.sort(tokens);

        int low = 0, high = tokens.length - 1;

        int maxScore = 0, currentScore = 0;

        while (low <= high) {

            if (power >= tokens[low]) {
                power -= tokens[low++];
                currentScore++;

                maxScore = Math.max(maxScore, currentScore);
            }

            else if (currentScore > 0) {
                power += tokens[high--];
                currentScore--;
            }

            else {
                break;
            }
        }
        return maxScore;
    }
}