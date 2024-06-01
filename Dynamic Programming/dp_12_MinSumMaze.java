import java.util.Arrays;

public class dp_12_MinSumMaze {

  static int getMaxUtil(int i, int j, int m, int[][] matrix, int[][] dp) {
    // Base Conditions
    if (j < 0 || j >= m) return (int) Math.pow(10, 9);
    if (i == 0) return matrix[0][j];

    if (dp[i][j] != -1) return dp[i][j];

    // Calculate three possible paths: moving up, left diagonal, and right diagonal
    int up = matrix[i][j] + getMaxUtil(i - 1, j, m, matrix, dp);
    int leftDiagonal = matrix[i][j] + getMaxUtil(i - 1, j - 1, m, matrix, dp);
    int rightDiagonal = matrix[i][j] + getMaxUtil(i - 1, j + 1, m, matrix, dp);

    // Store the maximum of the three paths in dp
    return dp[i][j] = Math.min(up, Math.min(leftDiagonal, rightDiagonal));
  }

  public int minFallingPathSum(int[][] matrix) {
    int n = matrix.length;
    int m = matrix[0].length;

    int dp[][] = new int[n][m];
    for (int row[] : dp) Arrays.fill(row, -1);

    int maxi = Integer.MAX_VALUE;

    // For each starting column, find the maximum path sum and update maxi
    for (int j = 0; j < m; j++) {
      int ans = getMaxUtil(n - 1, j, m, matrix, dp);
      maxi = Math.min(maxi, ans);
    }

    return maxi;
  }

  public int spaceOptimalSol(int[][] matrix) {
    int n = matrix.length; // Dimension of the square matrix
    int[] dpCurrentRow = new int[n]; // Current row dp array

    // Initialize dp with the first row of matrix.
    for (int j = 0; j < n; ++j) {
      dpCurrentRow[j] = matrix[0][j];
    }

    // Traverse from second row to the last row
    for (int rowIdx = 1; rowIdx < n; ++rowIdx) {
      // Cloning dp array to hold the values for this row calculations
      int[] dpNextRow = dpCurrentRow.clone();

      for (int colIdx = 0; colIdx < n; ++colIdx) {
        // Initialize minimum sum as the value above the current cell
        int minSumAbove = dpCurrentRow[colIdx];

        // If not in the first column, consider the upper-left neighbor
        if (colIdx > 0) {
          minSumAbove = Math.min(minSumAbove, dpCurrentRow[colIdx - 1]);
        }
        // If not in the last column, consider the upper-right neighbor
        if (colIdx + 1 < n) {
          minSumAbove = Math.min(minSumAbove, dpCurrentRow[colIdx + 1]);
        }

        // Update the dp array for the next row with the new minimum
        dpNextRow[colIdx] = minSumAbove + matrix[rowIdx][colIdx];
      }
      // Move to the next row
      dpCurrentRow = dpNextRow;
    }

    // After processing all the rows, find the minimum falling path sum
    int minFallingPathSum = Integer.MAX_VALUE;
    for (int x : dpCurrentRow) {
      minFallingPathSum = Math.min(minFallingPathSum, x);
    }

    return minFallingPathSum;
  }

    public static void main(String[] args) {
        int[][] matrix = { { 2, 1, 3 }, { 6, 5, 4 }, { 7, 8, 9 } };
        dp_12_MinSumMaze obj = new dp_12_MinSumMaze();
        System.out.println(obj.minFallingPathSum(matrix));
        System.out.println(obj.spaceOptimalSol(matrix));
    }
}
