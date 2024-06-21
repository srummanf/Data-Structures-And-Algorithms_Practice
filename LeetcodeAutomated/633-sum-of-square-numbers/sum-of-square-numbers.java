class Solution {
    public boolean judgeSquareSum(int c) {
        // Using long to prevent overflow when calculating squares
        long left = 0;
        long right = (long) Math.sqrt(c);
        
        // Loop until the two pointers cross each other
        while (left <= right) {
            long sum = left * left + right * right;
            
            if (sum == c) {
                return true;
            } else if (sum < c) {
                left++;
            } else {
                right--;
            }
        }
        return false;
    }
}
