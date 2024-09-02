class Solution {
    int totalPaths = 0;
    int emptyCells = 1; // Including the start cell

    public void dfs(int i, int j, int[][] grid, int r, int c, int er, int ec, int count) {
        // Boundary and obstacle check
        if (i < 0 || i >= r || j < 0 || j >= c || grid[i][j] == -1) {
            return;
        }

        // If we reach the end cell and have visited all the empty cells
        if (i == er && j == ec) {
            if (count == emptyCells) {
                totalPaths++;
            }
            return;
        }

        // Mark the cell as visited
        grid[i][j] = -1;

        // Explore all 4 possible directions
        dfs(i + 1, j, grid, r, c, er, ec, count + 1);
        dfs(i - 1, j, grid, r, c, er, ec, count + 1);
        dfs(i, j + 1, grid, r, c, er, ec, count + 1);
        dfs(i, j - 1, grid, r, c, er, ec, count + 1);

        // Backtrack: unmark the cell
        grid[i][j] = 0;
    }

    public int uniquePathsIII(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        int sr = -1, sc = -1;
        int er = -1, ec = -1;

        // Find start, end, and count the number of empty cells
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == 1) {
                    sr = i;
                    sc = j;
                }
                if (grid[i][j] == 2) {
                    er = i;
                    ec = j;
                }
                if (grid[i][j] == 0) {
                    emptyCells++;
                }
            }
        }

        // Start DFS from the start cell
        dfs(sr, sc, grid, r, c, er, ec, 0);
        return totalPaths;
    }
}


// class Solution {
//     int sum = 0;

//     public void dfs(int i, int j, int[][] grid, int r, int c, int er, int ec) {
//         if (i < 0 || i >= r || j < 0 || j >= c || grid[i][j] == -1)
//             sum += 0;
//         if (i == er && j == ec)
//             sum += 1;
//         dfs(i + 1, j, grid, r, c, er, ec);
//         dfs(i - 1, j, grid, r, c, er, ec);
//         dfs(i, j + 1, grid, r, c, er, ec);
//         dfs(i, j - 1, grid, r, c, er, ec);
//     }

//     public int uniquePathsIII(int[][] grid) {
//         int r = grid.length;
//         int c = grid[0].length;
//         int sr = -1;
//         int sc = -1;
//         int er = -1;
//         int ec = -1;
//         for (int i = 0; i < r; i++) {
//             for (int j = 0; j < c; j++) {
//                 if (grid[i][j] == 1) {
//                     sr = i;
//                     sc = j;
//                 }
//                 if (grid[i][j] == 2) {
//                     er = i;
//                     ec = j;
//                 }
//             }
//         }
//         dfs(sr, sc, grid, r, c, er, ec);
//         return sum;

//     }
// }