// https://leetcode.com/problems/longest-increasing-subsequence/description/

class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n];
        Arrays.fill(dp,1);
        int maxx = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    dp[i] = Math.max(dp[i],1+dp[j]);
                }
            }
            maxx = Math.max(dp[i],maxx);
        }
        return maxx;
    }
}

class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n];
        Arrays.fill(dp,1);
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(nums[j]>nums[i]) dp[j] = Math.max(dp[j],1+dp[i]);
            }
        }
        int maxx = 0;
        for(int i:dp) if(i>maxx) maxx = i;
        return maxx;
    }
}

class Solution {
    public int lengthOfLIS(int[] nums) {
        int dp[][] = new int[nums.length+1][nums.length+1];
        for(int[] i:dp)Arrays.fill(i,-1);
        return solve(0,-1,nums,dp);
    }
    public int solve(int idx, int prev, int[] nums,int[][] dp){
        if(idx>=nums.length) return 0;
        if(prev!=-1 && dp[idx][prev]!=-1) return dp[idx][prev];
        int take = 0;
        if(prev==-1 || nums[prev]<nums[idx]) take = 1 + solve(idx+1,idx,nums,dp);
        int skip = solve(idx+1,prev,nums,dp);
        if(prev!=-1) dp[idx][prev] = Math.max(take,skip);
        return Math.max(take,skip);
    }
}