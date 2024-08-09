class Solution {
    public int largestMagicSquare(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int maxK = Math.min(m, n);

        for (int k = maxK; k >= 1; k--) { // Check squares of decreasing size
            for (int i = 0; i <= m - k; i++) {
                for (int j = 0; j <= n - k; j++) {
                    if (isMagicSquare(grid, i, j, k)) {
                        return k; // Return the first (largest) k found
                    }
                }
            }
        }
        return 1; // If no larger magic square found, return 1 (1x1 is trivially a magic square)
    }

    private boolean isMagicSquare(int[][] grid, int row, int col, int k) {
        int targetSum = 0;

        // Calculate the target sum using the first row
        for (int j = 0; j < k; j++) {
            targetSum += grid[row][col + j];
        }

        // Check all rows
        for (int i = 0; i < k; i++) {
            int rowSum = 0;
            for (int j = 0; j < k; j++) {
                rowSum += grid[row + i][col + j];
            }
            if (rowSum != targetSum) return false;
        }

        // Check all columns
        for (int j = 0; j < k; j++) {
            int colSum = 0;
            for (int i = 0; i < k; i++) {
                colSum += grid[row + i][col + j];
            }
            if (colSum != targetSum) return false;
        }

        // Check both diagonals
        int diag1 = 0, diag2 = 0;
        for (int i = 0; i < k; i++) {
            diag1 += grid[row + i][col + i];
            diag2 += grid[row + i][col + k - i - 1];
        }
        if (diag1 != targetSum || diag2 != targetSum) return false;

        return true;
    }
}
