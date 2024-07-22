import java.util.Arrays;

class Solution {
    public int findLongestChain(int[][] pairs) {
        // Sort pairs based on their end values
        Arrays.sort(pairs, (a, b) -> Integer.compare(a[1], b[1]));

        int ctr = 0;

        // Iterate over each pair
        for (int i = 0; i < pairs.length; i++) {
            int temp = 1;
            int end = pairs[i][1];

            // Check for the longest chain starting from the current pair
            for (int j = i + 1; j < pairs.length; j++) {
                if (pairs[j][0] > end) {
                    temp++;
                    end = pairs[j][1];
                }
            }

            // Update the maximum chain length found so far
            ctr = Math.max(ctr, temp);
        }

        return ctr;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] pairs1 = {{1,2}, {2,3}, {3,4}};
        System.out.println(solution.findLongestChain(pairs1)); // Output: 2

        int[][] pairs2 = {{1,2}, {7,8}, {4,5}};
        System.out.println(solution.findLongestChain(pairs2)); // Output: 3
    }
}
