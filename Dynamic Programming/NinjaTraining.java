//  Striver DP 8 : https://www.youtube.com/watch?v=AE39gJYuRog&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=8

import java.util.*;

class NinjaTraining {

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
        if(i!=last) {
            int pts = a[day][i] + maxPointsRecursion(day - 1, i, a);
            maxi2 = Math.max(maxi2, pts);
        }
    }
    return maxi2;
  }


  int maxPointsTopDown_Memoization(int day, int last, int a[][], int dp[][]) {
    if (day == 0) {
      int maxi = 0;
      for (int i = 0; i < 3; i++) {
        if (i != last) {
          maxi = Math.max(maxi, a[0][i]);
        }
      }
      return maxi;
    }
    if(dp[day][last] != -1) return dp[day][last];
    int maxi2 = 0;
    for (int i = 0; i < 3; i++) {
        if(i!=last) {
            int pts = a[day][i] + maxPointsTopDown_Memoization(day - 1, i, a, dp);
            maxi2 = Math.max(maxi2, pts);
        }
    }
    return dp[day][last] = maxi2;
  }

  public static void main(String[] args) {
    NinjaTraining h = new NinjaTraining();
    int a[][] = {{1,2,3}, {10,11,12}, {100,101,102}};
    int dp[][] = new int[3][3];
    for(int i=0;i<3;i++) {
        for(int j=0;j<3;j++) {
            dp[i][j] = -1;
        }
        
    }
    System.out.println(dp[0][1]);
    // System.out.println(h.maxPointsRecursion(2, -1, a));
    // System.out.println(h.maxPointsTopDown_Memoization(2, -1, a, dp));
  }

}
