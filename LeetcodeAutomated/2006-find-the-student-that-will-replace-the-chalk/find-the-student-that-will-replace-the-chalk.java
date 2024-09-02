class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        int n = chalk.length;
        long sum = 0;

        for (int i : chalk) {
            sum += i;
        }

        // Subtract the sum of chalk from k until k is less than the sum of chalk.
        int rem = (int)(k % sum);

        // Iterate through each student to find who cannot use the required chalk
        for (int i = 0; i < n; i++) {
            if (rem < chalk[i]) {
                return i;
            } else {
                rem -= chalk[i];
            }
        }

        // Fallback return statement (though this won't be reached)
        return 0;
    }
}


/**
 * TLE --> O(n)
 * public int chalkReplacer(int[] chalk, int k) {
 * int n = chalk.length;
 * int idx = 0;
 * int ans = 0;
 * while (k >= 0) {
 * k = k - chalk[idx++];
 * ans = idx;
 * if (idx % n == 0)
 * idx = 0;
 * }
 * return ans-1;
 * }
 * 
 */