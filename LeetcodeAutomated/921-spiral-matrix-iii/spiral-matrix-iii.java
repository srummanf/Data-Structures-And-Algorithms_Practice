class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int[][] directions = {
            {0, 1},  // EAST
            {1, 0},  // SOUTH
            {0, -1}, // WEST
            {-1, 0}  // NORTH
        };
        
        int[][] result = new int[rows * cols][2];  
        int step = 0; // how many steps to move
        int dir  = 0; // which direction

        result[0] = new int[]{rStart, cStart};
        int idx = 1;

        while (idx < rows * cols) {
            // When we move EAST or WEST, we need to increase our steps by 1
            if (dir == 0 || dir == 2) step++;

            for (int i = 0; i < step; i++) {
                rStart += directions[dir][0];
                cStart += directions[dir][1];

                if (rStart >= 0 && rStart < rows && cStart >= 0 && cStart < cols) { 
                    result[idx++] = new int[]{rStart, cStart};
                }
            }

            dir = (dir + 1) % 4; 
        }
        
        return result;
    }
}