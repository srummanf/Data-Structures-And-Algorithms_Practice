import java.util.Arrays;

/**
 * Triangle - Fixed starting point, variable ending point
 * Find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
 * DP 11
 * https://www.youtube.com/watch?v=SrP-PiLSYC0&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=12
 * 
 * Refer this for space optimization: https://takeuforward.org/data-structure/minimum-path-sum-in-triangular-grid-dp-11/
 *
 Recurrence:
 if(i==n-1) return a[n-1][j];
 d=a[i][j] + f(i+1,j);
 dg=a[i][j] + f(i+1,j+1);

 return min(d,dg)
 */
import java.util.Arrays;
public class Triangle {

    int recursion(int[][] a, int i, int j) {
        int n = a.length;
        if(i==n-1) return a[i][j];
        int d=a[i][j] + recursion(a,i+1,j);
        int dg=a[i][j] + recursion(a,i+1,j+1);
        return Math.min(d,dg);
    }

    int topDownMemoization(int[][] a, int i, int j, int[][] dp) {
        int n = a.length;
        if(i==n-1) return dp[i][j] = a[i][j];
        if(dp[i][j]!=-1) return dp[i][j];
        int d=a[i][j] + topDownMemoization(a,i+1,j,dp);
        int dg=a[i][j] + topDownMemoization(a,i+1,j+1,dp);
        return dp[i][j] = Math.min(d,dg);
    }


    int bottomUpTabulation(int[][] a) {
        int n = a.length;
        int[][] dp = new int[n][n];
        for(int i=0;i<n;i++) {
            dp[n-1][i] = a[n-1][i];
        }
        for(int i=n-2;i>=0;i--) {
            for(int j=0;j<=i;j++) {
                dp[i][j] = a[i][j] + Math.min(dp[i+1][j],dp[i+1][j+1]);
            }
        }
        return dp[0][0];
    }


    public static void main(String[] args) {
        Triangle t = new Triangle();
        int[][] a = {{2},{3,4},{6,5,7},{4,1,8,3}};
        int n = a.length;
        int dp[][] = new int[n][n];
        for (int row[] : dp)
            Arrays.fill(row, -1);
        System.out.println(t.recursion(a,0,0));
        System.out.println(t.bottomUpTabulation(a));
        System.out.println(t.topDownMemoization(a,0,0,dp));
    }

}