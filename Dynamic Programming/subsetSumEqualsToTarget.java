// Recursive solutione
// boolean f(int ind, int target, int arr[]){
//     if(target==0) return true;
//     if(ind==0) return arr[0]= =target; --> This will return true if array[0] equal to target

//     boolean nottake = f(ind-1, target, arr);
//     boolean take = false;
//     if(a[ind]<= target){
//         take = f(ind-1, target-a[ind], arr);
//     }

//     return take || nottake;
// }

import java.util.Arrays;

public class subsetSumEqualsToTarget {

  boolean f(int ind, int target, int arr[]) {
    if (target == 0) return true;
    if (ind == 0) return arr[0] == target;

    boolean nottake = f(ind - 1, target, arr);
    boolean take = false;
    if (arr[ind] <= target) {
      take = f(ind - 1, target - a[ind], arr);
    }

    return take || nottake;
  }

  // Memoization

  public static boolean f(int ind, int target, int[] arr, int[][] dp) {
    // If the target sum is achieved, return true
    if (target == 0) return true;

    // If we have considered all elements but haven't reached the target, return false
    if (ind == 0) return arr[0] == target;

    // If the result for this subproblem has already been calculated, return it
    if (dp[ind][target] != -1) return dp[ind][target] == 0 ? false : true;

    // Try not taking the current element
    boolean notTaken = f(ind - 1, target, arr, dp);

    // Try taking the current element if it doesn't exceed the target
    boolean taken = false;
    if (arr[ind] <= target) taken = f(ind - 1, target - arr[ind], arr, dp);

    // Store the result in the DP table and return whether either option was successful
    dp[ind][target] = notTaken || taken ? 1 : 0;
    return notTaken || taken;
  }

  public static boolean subsetSumToK(int n, int k, int arr[]) {
    // Write your code here.
    int dp[][] = new int[n][k + 1];
    for (int row[] : dp) Arrays.fill(row, -1);
    return f(n - 1, k, arr, dp);
  }
}
