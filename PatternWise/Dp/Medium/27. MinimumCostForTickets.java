// https://leetcode.com/problems/minimum-cost-for-tickets/

class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int n = days.length;
        int dp[] = new int[n];
        Arrays.fill(dp,-1);
        return solve(days,costs,dp,0);
    }
    public int solve(int []days, int []costs, int []dp, int idx){
        if(idx>=days.length) return 0;
        if(dp[idx]!=-1) return dp[idx];
        int first = costs[0] + solve(days,costs,dp,idx+1);
        int j = idx;
        int maxdays = days[idx] + 7;
        while(j<days.length && days[j]<maxdays) j++;
        int second = costs[1] + solve(days,costs,dp,j);
        j = idx;
        maxdays = days[idx] + 30;
        while(j<days.length && days[j]<maxdays) j++;
        int third = costs[2] + solve(days,costs,dp,j);
        return dp[idx] = Math.min(first,Math.min(second,third));
    }
} 