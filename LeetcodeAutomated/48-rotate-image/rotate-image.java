class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix[0].length;
        int copy[][] = new int[n][n];
        for(int i = 0; i<n ; i++){
            for (int j = 0; j < n; j++){
                copy[i][j] = matrix[i][j];
                System.out.println(copy[i][j] );
            } 
        }
        int c = n;
        for (int i = 0; i < n; i++) {
            c = n - 1;
            for (int j = 0; j < n; j++) {
                matrix[i][j] = copy[c][i];
                System.out.println(c+"--"+i+"--"+copy[c][i]);
                c--;
            }
        }

    }
}