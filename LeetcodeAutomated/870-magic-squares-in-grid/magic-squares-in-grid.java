class Solution {
    public boolean isMagicSquare(int[][] grid, int row, int col) {
        HashSet<Integer> hm = new HashSet<>();
        int rowsum1 = grid[row][col] + grid[row][col + 1] + grid[row][col + 2];
        int rowsum2 = grid[row + 1][col] + grid[row + 1][col + 1] + grid[row + 1][col + 2];
        int rowsum3 = grid[row + 2][col] + grid[row + 2][col + 1] + grid[row + 2][col + 2];

        int colsum1 = grid[row][col] + grid[row + 1][col] + grid[row + 2][col];
        int colsum2 = grid[row][col + 1] + grid[row + 1][col + 1] + grid[row + 2][col + 1];
        int colsum3 = grid[row][col + 2] + grid[row + 1][col + 2] + grid[row + 2][col + 2];

        int diagsum = grid[row][col] + grid[row + 1][col + 1] + grid[row + 2][col + 2];

        for (int i = row; i < row + 3; i++) {
            for (int j = col; j < col + 3; j++) {
                hm.add(grid[i][j]);
                if (grid[i][j] > 9 || grid[i][j]<=0) {
                    return false;
                }
            }
        }

        if (hm.size() != 9)
            return false;

        return rowsum1 == rowsum2 && rowsum1 == rowsum3 && colsum1 == colsum2 && colsum1 == colsum3
                && rowsum1 == diagsum && colsum1 == diagsum;
    }

    public int numMagicSquaresInside(int[][] grid) {
        int ctr = 0;
        int r = grid.length;
        int c = grid[0].length;
        for (int i = 0; i < r - 3 + 1; i++) {
            for (int j = 0; j < c - 3 + 1; j++) {
                if (isMagicSquare(grid, i, j)) {
                    ctr++;
                }
            }
        }

        return ctr;
    }
}