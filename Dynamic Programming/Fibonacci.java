import java.util.*;
// Memoization 
class Fibonacci {

  int fib(int n, int dp[]) {
    if (n <= 1) {
      return n;
    } else if (dp[n] != -1) {
      return dp[n];
    } else {
      return dp[n] = fib(n - 1, dp) + fib(n - 2, dp);
    }
  }

  public static void main(String[] args) {
    Fibonacci f = new Fibonacci();
    int n = 10;
    int dp[] = new int[n + 1];
    Arrays.fill(dp, -1);
    System.out.println(f.fib(n, dp));
  }
}
