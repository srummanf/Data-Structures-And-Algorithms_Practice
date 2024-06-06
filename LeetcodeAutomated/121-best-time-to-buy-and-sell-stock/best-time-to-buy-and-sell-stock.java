class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int minCostToBuy = prices[0];
        for(int i=1 ;i<prices.length; i++){
            int currProfit = prices[i] - minCostToBuy;
            minCostToBuy = Math.min(minCostToBuy, prices[i]);
            profit = Math.max(profit, currProfit);
        }   
        return profit;
    }
}