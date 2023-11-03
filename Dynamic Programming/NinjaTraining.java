//  Striver DP 7 : https://www.youtube.com/watch?v=AE39gJYuRog&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=8

import java.util.*;

class NinjaTraining {

  // -------------------------------------------------------------- RECURSION --------------------------------------------------------------
  
  int maxPointsRecursion(int day, int last, int a[][]) {
    if (day == 0) {
      int maxi = 0;
      for (int i = 0; i < 3; i++) {
        if (i != last) {
          maxi = Math.max(maxi, a[0][i]);
        }
      }
      return maxi;
    }
    int maxi2 = 0;
    for (int i = 0; i < 3; i++) {
      if (i != last) {
        int pts = a[day][i] + maxPointsRecursion(day - 1, i, a);
        maxi2 = Math.max(maxi2, pts);
      }
    }
    return maxi2;
  }


  // -------------------------------------------------------------- TOP DOWN - MEMOIZATION --------------------------------------------------------------
  
  int maxPointsTopDown_Memoization(int day, int last, int a[][], int dp[][]) {
    if (day == 0) {
      int maxi = 0;
      for (int i = 0; i < 3; i++) {
        if (i != last) {
          maxi = Math.max(maxi, a[0][i]);
        }
      }
      return dp[day][last] = maxi;
    }
    if (dp[day][last] != -1) return dp[day][last];

    int maxi2 = 0;
    for (int i = 0; i < 3; i++) {
      if (i != last) {
        int pts = a[day][i] + maxPointsTopDown_Memoization(day - 1, i, a, dp);
        maxi2 = Math.max(maxi2, pts);
      }
    }
    return dp[day][last] = maxi2;
  }
  
  // -------------------------------------------------------- STRIVER'S CODE -----------------------------------------------------------
  // ---------------------------------------------------- TOP DOWN - MEMOIZATION --------------------------------------------------------------
  
  static int f(int day, int last, int[][] points, int[][] dp) {
    // If the result is already calculated, return it
    if (dp[day][last] != -1) return dp[day][last];
    
    // Base case: When it's the first day (day == 0)
    if (day == 0) {
      int maxi = 0;
      for (int i = 0; i <= 2; i++) {
        if (i != last) maxi = Math.max(maxi, points[0][i]);
      }
      return dp[day][last] = maxi; // Store and return the result
    }
    
    int maxi = 0;
    // Loop through the three activities on the current day
    for (int i = 0; i <= 2; i++) {
      if (i != last) {
        // Calculate the points for the current activity and recursively
        // calculate the maximum points for the previous day
        int activity = points[day][i] + f(day - 1, i, points, dp);
        maxi = Math.max(maxi, activity); // Update the maximum points
      }
    }
    
    return dp[day][last] = maxi; // Store and return the result
  }
  
  // Function to find the maximum points for ninja training
  static int ninjaTraining(int n, int[][] points) {
    // Initialize a memoization table with -1 values
    int dp[][] = new int[n][4];
    for (int[] row : dp) Arrays.fill(row, -1);

    // Start the recursive calculation from the last day (n - 1) with the last activity (3)
    return f(n - 1, 3, points, dp);
  }
  // ---------------------------------------------------- BOTTOM UP - TABULATION --------------------------------------------------------------
  
  static int maxPointsBottomUp_Tabulation(int n, int[][] points) {
        // Initialize a 2D array 'dp' to store the maximum points
        int[][] dp = new int[n][4];
        
        // Initialize the first day's maximum points based on the available choices
        dp[0][0] = Math.max(points[0][1], points[0][2]);
        dp[0][1] = Math.max(points[0][0], points[0][2]);
        dp[0][2] = Math.max(points[0][0], points[0][1]);
        dp[0][3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));

        // Iterate through each day and each activity
        for (int day = 1; day < n; day++) {
            for (int last = 0; last < 4; last++) {
                dp[day][last] = 0; // Initialize the maximum points for the current day and last activity
                // Consider each possible task for the current day
                for (int task = 0; task <= 2; task++) {
                    if (task != last) { // Ensure that the current task is different from the last
                        // Calculate the points for the current activity and add it to the maximum points from the previous day
                        int activity = points[day][task] + dp[day - 1][task];
                        // Update the maximum points for the current day and last activity
                        dp[day][last] = Math.max(dp[day][last], activity);
                    }
                }
            }
        }

        // Return the maximum points achievable after all days (last activity is 3)
        return dp[n - 1][3];
    }


  
  // ---------------------------------------------------------------- MAIN FUNCTION --------------------------------------------------------------
  
  public static void main(String[] args) {
    NinjaTraining h = new NinjaTraining();
    int a[][] = { { 1, 2, 3 }, { 10, 11, 12 }, { 100, 101, 102 } };
    int[][] points = { { 10, 40, 70 }, { 20, 50, 80 }, { 30, 60, 90 } };
    int nn = points.length;
    int dp[][] = new int[nn][nn+1];
    for (int i = 0; i < nn; i++) {
      for (int j = 0; j < (nn+1); j++) {
        dp[i][j] = -1;
      }
    }
    System.out.println(dp[0][1]);
    // System.out.println(h.maxPointsRecursion(2, -1, a));
    System.out.println("TopDown_Memoization : My Code: " + h.maxPointsTopDown_Memoization(a.length - 1, 3, points, dp));

    

    int n = points.length; // Get the number of days
    System.out.println("TopDown_Memoization : Striver's Code: " + ninjaTraining(n, points));
    System.out.println("BottomUp_Tabulation : Striver's Code: " + maxPointsBottomUp_Tabulation(n, points));
  }
}
