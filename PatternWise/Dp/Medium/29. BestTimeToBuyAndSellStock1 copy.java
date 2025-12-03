// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/

class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length, mini = prices[0],maxProfit = 0;
        for(int i=1;i<n;i++){
            int cost = prices[i]-mini;
            maxProfit = Math.max(maxProfit,cost);
            mini = Math.min(mini,prices[i]);
        }
        return maxProfit;
    }
}