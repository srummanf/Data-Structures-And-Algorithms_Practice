class Solution {

    public static <T> ArrayList<T> intersection(HashSet<T> set1, HashSet<T> set2) {
        HashSet<T> resultSet = new HashSet<>(set1);
        resultSet.retainAll(set2);
        return new ArrayList<>(resultSet);
    }


    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int r =  matrix.length;
        int c =  matrix[0].length;
        HashSet<Integer> hash = new HashSet<>();
        HashSet<Integer> hashmax = new HashSet<>();
        
        for(int i = 0; i<r ; i++){
            int mini = Integer.MAX_VALUE;
            for(int j = 0; j<c; j++){
                mini = Math.min(mini, matrix[i][j]);
            }
            hash.add(mini);
        }


        for(int i = 0; i<c ; i++){
            int maxi = Integer.MIN_VALUE;
            for(int j = 0; j<r; j++){
                maxi = Math.max(maxi, matrix[j][i]);
            }
            hashmax.add(maxi);
        }

        System.out.println(hash + "---" + hashmax);

        return intersection(hash, hashmax);




        
        
    }
}