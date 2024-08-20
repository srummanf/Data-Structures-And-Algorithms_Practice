class Solution {
    public int solve(int numberOfA, int clipboard, int n, int[][] dp) {
        if (n == numberOfA)
            return 0;
        if (numberOfA > n)
            return 1000;

        if (dp[numberOfA][clipboard] != -1)
            return dp[numberOfA][clipboard];

        int copyAndPaste = 2 + solve(numberOfA + numberOfA, numberOfA, n, dp);
        int paste = 1 + solve(numberOfA + clipboard, clipboard, n, dp);

        return dp[numberOfA][clipboard] = Math.min(copyAndPaste, paste);

    }

    public int minSteps(int n) {

        int[][] dp = new int[1001][1001];
        for (int[] a : dp)
            Arrays.fill(a, -1);

        if (n == 1)
            return 0;

        return 1 + solve(1, 1, n, dp);

    }
}

// class Solution {
// public int paste(int n) {
// return n + 1;
// }

// public int copy(int n) {
// return n + 1;
// }

// public int minSteps(int n) {
// if (n == 1)
// return 0;
// int ctr = 0;
// int idx = 0;
// while (n > 0)
// if (ctr <= n) {
// ctr += copy(n);
// ctr += paste(n);
// n -= (int)Math.pow(2, idx++);
// }

// return 0;
// }
// }

// Accepted Solution - ChatGPT
// class Solution {
// public int minSteps(int n) {
// if(n==1) return 0;

// int count = 0;
// for (int i = 2; i <= n; i++) {
// while (n % i == 0) {
// count += i;
// n = n / i;
// }
// }
// return count;
// }
// }
