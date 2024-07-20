class Solution {

    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int N = rowSum.length;
        int M = colSum.length;

        int[][] origMatrix = new int[N][M];
        int i = 0, j = 0;

        while (i < N && j < M) {
            origMatrix[i][j] = Math.min(rowSum[i], colSum[j]);

            rowSum[i] -= origMatrix[i][j];
            colSum[j] -= origMatrix[i][j];

            if (rowSum[i] == 0) {
                i++;
            } else {
                j++;
            }
        }

        return origMatrix;
    }
}