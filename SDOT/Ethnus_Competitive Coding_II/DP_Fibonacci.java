// Returns the kth value in the BST

import java.util.*;

public class DP_Fibonacci {

  public static int fib(int n, int dp[]) {
    if (n <= 1) {
      return n;
    } else {
      if (dp[n] != -1) {
        return dp[n];
      } else {
        return dp[n] = fib(n - 1, dp) + fib(n - 2, dp);
      }
    }
  }

  public static int fib_rec(int n) {
    if (n <= 1) return n;
    return fib_rec(n - 1) + fib_rec(n - 2);
  }

  public static void main(String[] args) {
    int n = 6;
    int dp[] = new int[n + 1];
    Arrays.fill(dp, -1);
    System.out.println(fib(n, dp));
    System.out.println(fib_rec(n));
  }
}
