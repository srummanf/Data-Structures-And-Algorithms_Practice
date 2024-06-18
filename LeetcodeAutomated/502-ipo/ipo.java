import java.util.PriorityQueue;

class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        
        // Min-Heap to store projects by their capital requirements
        PriorityQueue<int[]> minCapitalHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        // Max-Heap to store profits of the projects we can afford
        PriorityQueue<int[]> maxProfitHeap = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        
        // Insert all projects into the Min-Heap
        for (int i = 0; i < n; i++) {
            minCapitalHeap.add(new int[]{capital[i], profits[i]});
        }
        
        // Try to complete k projects
        for (int i = 0; i < k; i++) {
            // Move all affordable projects to the Max-Heap
            while (!minCapitalHeap.isEmpty() && minCapitalHeap.peek()[0] <= w) {
                maxProfitHeap.add(minCapitalHeap.poll());
            }
            
            // If no projects can be done, break
            if (maxProfitHeap.isEmpty()) {
                break;
            }
            
            // Take the project with the maximum profit
            w += maxProfitHeap.poll()[1];
        }
        
        return w;
    }
}
