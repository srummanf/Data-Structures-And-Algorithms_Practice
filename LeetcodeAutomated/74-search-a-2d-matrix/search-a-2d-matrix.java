class Solution {
    public static int binarySearch(int array[][], int x, int low, int high, int xr) {
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (array[xr][mid] == x)
                return mid;

            if (array[xr][mid] < x)
                low = mid + 1;

            else
                high = mid - 1;
        }

        return -1;
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int r = matrix.length;
        int c = matrix[0].length;

        if (r == 1 && c == 1)
            return matrix[0][0] == target;

        int xr = 0;
        while (xr < r) {
            if (target >= matrix[xr][0] && target <= matrix[xr][c - 1]) {
                break;
            } else {
                xr++;
            }
        }
        if (xr == r)
            return false;

        int high = c - 1;

        int val = binarySearch(matrix, target, 0, c - 1, xr);

        return val == -1 ? false : true;

    }
}