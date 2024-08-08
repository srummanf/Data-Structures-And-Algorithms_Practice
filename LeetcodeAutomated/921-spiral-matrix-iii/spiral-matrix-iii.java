class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int[][] ans = new int[rows * cols][2]; // Correct size of the result array
        int[][] direction = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } }; // E, S, W, N
        int steps = 1; // Initial steps in a direction
        int dir = 0; // Direction index
        int idx_x = 0; // Index for filling ans

        ans[idx_x][0] = rStart;
        ans[idx_x][1] = cStart;
        idx_x++;

        while (idx_x < rows * cols) {
            for (int i = 0; i < 2; i++) { // Increase steps every two directions (E and W or N and S)
                for (int j = 0; j < steps; j++) {
                    rStart += direction[dir][0];
                    cStart += direction[dir][1];
                    if (rStart >= 0 && rStart < rows && cStart >= 0 && cStart < cols) {
                        ans[idx_x][0] = rStart;
                        ans[idx_x][1] = cStart;
                        idx_x++;
                    }
                }
                dir = (dir + 1) % 4; // Change direction
            }
            steps++; // Increment steps after completing a full cycle of directions
        }

        return ans;
    }
}
