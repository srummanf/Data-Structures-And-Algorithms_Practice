class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int jobCount = difficulty.length; // The total number of jobs
        List<int[]> jobs = new ArrayList<>(); // A list to hold jobs with their difficulty and profit
      
        // Add each job's difficulty and profit as int array to the jobs list
        for (int i = 0; i < jobCount; ++i) {
            jobs.add(new int[] {difficulty[i], profit[i]});
        }
      
        // Sort the jobs list by their difficulty
        jobs.sort(Comparator.comparing(a -> a[0]));
      
        // Sort the worker array to prepare for the job assignment
        Arrays.sort(worker);
      
        int totalProfit = 0; // Variable to keep track of the total profit
        int maxProfit = 0;  // Variable to keep track of the maximum profit found so far
        int jobIndex = 0;   // Index to iterate through the sorted jobs
      
        // Iterate through each worker's ability
        for (int ability : worker) {
            // While the job index is within bounds and the worker can handle the job difficulty
            while (jobIndex < jobCount && jobs.get(jobIndex)[0] <= ability) {
                // Update the maximum profit if the current job offers more 
                maxProfit = Math.max(maxProfit, jobs.get(jobIndex)[1]);
                jobIndex++; // Move to the next job
            }
            // Sum up the maximum profit the worker can make
            totalProfit += maxProfit;
        }
      
        return totalProfit; // Return the total profit from all workers
    }
}
