class Solution {
    public int maxDistance(int[] positions, int m) {
        // Sort the positions array to establish ordered distances
        Arrays.sort(positions);
      
        // Set initial search boundary for the maximum distance
        int left = 1;                 // Minimum possible distance
        int right = positions[positions.length - 1]; // Maximum possible distance
      
        // Use binary search to find the largest minimum distance between m balls
        while (left < right) {
            // Calculate the middle value of the current search boundary
            int mid = (left + right + 1) >>> 1;
          
            // Check if it's possible to place m balls with at least 'mid' distance apart
            if (isFeasible(positions, mid, m)) {
                left = mid; // If possible, continue the search on the right half
            } else {
                right = mid - 1; // If not possible, continue the search on the left half
            }
        }
      
        // Return the maximum minimum distance found
        return left;
    }

    // Helper method to check if m balls can be placed with at least 'distance' units apart
    private boolean isFeasible(int[] positions, int distance, int m) {
        // Start from the first position
        int prevPosition = positions[0];
        // One ball is already placed at the first position
        int count = 1;
      
        // Iterate through the positions to place the rest of the balls
        for (int i = 1; i < positions.length; ++i) {
            int currentPosition = positions[i];
          
            // If the current position is at least 'distance' away from the previously placed ball
            if (currentPosition - prevPosition >= distance) {
                // Place the ball and move to the next
                prevPosition = currentPosition;
                ++count; // Increment the count of placed balls
            }
        }
      
        // If the count of placed balls is at least m, it's feasible
        return count >= m;
    }
}