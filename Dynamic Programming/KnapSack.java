/**
 *  3  2  4
 * 30 40 60
 * 0  1  2
 * f(2,6) --> Till index 2 what is the max value you can get with weight 6
 *
 * nottake = 0 + f(ind-1, W)
 * take = intmin;
 * if(wt[ind] <= W) take = val[ind] + f(ind-1, W-wt[ind])
 * return max(take, nottake)
 */
import java.util.*;

public class KnapSack {

  static int recursion(int ind, int W, int[] wt, int[] val) {
    if (ind == 0) {
      if (wt[ind] <= W) return val[ind]; else return 0;
    }
    int nottake = recursion(ind - 1, W, wt, val);
    int take = Integer.MIN_VALUE;
    if (wt[ind] <= W) {
      take = val[ind] + recursion(ind - 1, W - wt[ind], wt, val);
    }
    return Math.max(take, nottake);
  }

  static int DP_topdown(int ind, int W, int[] wt, int[] val, int[][] dp) {
    if (ind == 0) {
      if (wt[ind] <= W) {
        return val[ind];
      } else {
        return 0;
      }
    }
    if (dp[ind][W] != -1) return dp[ind][W];
    int nottake = DP_topdown(ind - 1, W, wt, val, dp);
    int take = Integer.MIN_VALUE;
    if (wt[ind] <= W) {
      take = val[ind] + DP_topdown(ind - 1, W - wt[ind], wt, val, dp);
    }
    return dp[ind][W] = Math.max(take, nottake);
  }

  static int bottomUpKnapsack(int W, int[] wt, int[] val, int n) {
    int[][] dp = new int[n + 1][W + 1];

    // Base case: If the weight capacity is 0, then the maximum profit is 0
    for (int i = 0; i <= n; i++) {
      dp[i][0] = 0;
    }

    // Base case: If there are no items, then the maximum profit is 0
    for (int j = 0; j <= W; j++) {
      dp[0][j] = 0;
    }

    // Fill the dp table in a bottom-up manner
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= W; j++) {
        int nottake = dp[i - 1][j]; // Not taking the current item
        int take = 0;

        if (wt[i - 1] <= j) { // If the weight of the current item is less than or equal to the remaining weight capacity
          take = val[i - 1] + dp[i - 1][j - wt[i - 1]]; // Taking the current item
        }

        dp[i][j] = Math.max(take, nottake); // Store the maximum value of take and nottake
      }
    }

    return dp[n][W]; // Return the maximum profit
  }

  public static void main(String[] args) {
    int[] wt = { 1, 2, 3 };
    int[] val = { 10, 15, 40 };
    int W = 6;
    int dp[][] = new int[wt.length + 1][W + 1];
    for (int i = 0; i <= wt.length; i++) {
      Arrays.fill(dp[i], -1);
    }
    System.out.println(recursion(wt.length - 1, W, wt, val));
    System.out.println(DP_topdown(wt.length - 1, W, wt, val, dp));
    System.out.println(bottomUpKnapsack(W, wt, val, wt.length));
  }
}
