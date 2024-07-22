class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> Integer.compare(a[1], b[1]));
        
        int ctr = 0;
        int currentEnd = Integer.MIN_VALUE;

        // Iterate through sorted pairs and form the longest chain
        for (int[] pair : pairs) {
            if (pair[0] > currentEnd) {
                ctr++;
                currentEnd = pair[1];
            }
        }

        return ctr;

    }
}