class Solution {
    public double averageWaitingTime(int[][] customers) {
        double totalWaitingTime = 0;
        int currentTime = 0;
        
        for (int i = 0; i < customers.length; i++) {
            int arrivalTime = customers[i][0];
            int prepTime = customers[i][1];
            
            if (currentTime < arrivalTime) {
                currentTime = arrivalTime;
            }
            
            totalWaitingTime += (currentTime + prepTime - arrivalTime);
            currentTime += prepTime;
        }
        
        return totalWaitingTime / customers.length;
    }
}
