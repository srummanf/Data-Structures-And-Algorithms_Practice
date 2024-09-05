class Solution {
    public static int[] findOneCombination(int N, int k, int a, int b) {
        int[] result = new int[k];
        int remainingSum = N;
        int idx = 0;

        for (int i = 0; i < k; i++) {
            int maxPart = Math.min(b, remainingSum - (k - 1 - i) * a);
            int part = Math.max(a, remainingSum - (k - 1 - i) * b);
            result[idx++] = part;
            remainingSum -= part;
        }

        return result;
    }

    public int[] missingRolls(int[] rolls, int mean, int n) {
        int totalLen = rolls.length + n;
        int total = mean * totalLen;
        int sum = 0;
        for (int i : rolls)
            sum += i;
        if ((total - sum) < n || (total - sum) > 6 * n)
            return new int[] {};

        int[] ans = findOneCombination(total - sum, n, 1, 6);

        return ans;

    }
}