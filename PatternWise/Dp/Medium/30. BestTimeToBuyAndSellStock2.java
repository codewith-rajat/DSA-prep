// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/

class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int ahead[] = new int[2];
        int curr[] = new int[2];
        ahead[0] = ahead[1] = 0;
        int profit = 0;
        for(int ind=n-1;ind>=0;ind--){
            for(int buy=0;buy<=1;buy++){
                if(buy==1){
            profit = Math.max((-prices[ind]+ahead[0]),0+ahead[1]);
                }else{
            profit = Math.max((prices[ind]+ahead[1]),0+ahead[0]);
                }
            curr[buy]=profit;
            }
            ahead = curr;
        }
        return ahead[1];
    }
}

class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int dp[][] = new int[n+1][2];
        dp[n][0] = dp[n][1] = 0; //base case
        int profit = 0;
        for(int ind=n-1;ind>=0;ind--){
            for(int buy=0;buy<=1;buy++){
                if(buy==1){
            profit = Math.max((-prices[ind]+dp[ind+1][0]),0+dp[ind+1][1]);
                }else{
            profit = Math.max((prices[ind]+dp[ind+1][1]),0+dp[ind+1][0]);
                }
            dp[ind][buy]=profit;
            }
        }
        return dp[0][1];
    }
}

class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int dp[][] = new int[n][2];
        for(int i=0;i<n;i++) Arrays.fill(dp[i],-1);
        int ans = help(0,1,prices,dp);
        return ans;
    }
    public int help(int ind, int buy, int[] prices,int [][]dp){
        if(ind==prices.length) return 0;
        if(dp[ind][buy]!=-1) return dp[ind][buy];
        int profit = 0;
        if(buy==1){
            profit = Math.max((-prices[ind]+help(ind+1,0,prices,dp)),0+help(ind+1,1,prices,dp));
        }else{
            profit = Math.max((prices[ind]+help(ind+1,1,prices,dp)),0+help(ind+1,0,prices,dp));
        }
        return dp[ind][buy] = profit;
    }
}