/**
 * A man wants to do rock climbing to the top of the peak steep
 * 
 * N -> No of convenient rocks
 * I -> Current position
 * X -> Max rocks he can skip
 * 
 * Find the number of ways a mountaineer can climb the peak
 * 
 * int f(N,I,X){
 * if(i==0)
 * return 0
 * if(i<x)
 * return i
 * return X + f(N, I-X, X)
 * }
 */

public class StaircaseDP {
    public static int f(int n, int i, int x, int dp[]) {
        if (i == 0)
            return 0;
        if (i < x)
            return i;

        if (dp[i] != -1) {
            return dp[i];
        }
        return dp[i] = x + f(n, i - x, x, dp);
    }

    public static void main(String[] args) {
        int n = 6;
        int i = 3;
        int k = 2;
        int dp[] = new int[n + 1];
        for (int j = 0; j < n + 1; j++) {
            dp[j] = -1;
        }
        System.out.println(f(n, i, k, dp));
    }
}
