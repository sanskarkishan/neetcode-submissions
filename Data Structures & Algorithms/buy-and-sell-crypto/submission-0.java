class Solution {
    public int maxProfit(int[] prices) {
        // Buy Price = 1st element and Profit  = 0;
        // Now from 1 to n check if prices[i] > buy -> profit =  max(profit, prices[i]-buy);
        // else buy = prices[i]

        int n = prices.length;
        int buy = prices[0];
        int profit = 0;
        for (int i = 1; i < n; i++) {
            if (prices[i] > buy) {
                profit = Math.max(prices[i] - buy, profit);
            } else {
                buy = prices[i];
            }
        }
        return profit;
    }
}
