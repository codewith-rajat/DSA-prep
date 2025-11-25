// https://leetcode.com/problems/triangle/description/

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int dp[][] = new int[n][n];
        for(int [] arr : dp) Arrays.fill(arr,Integer.MAX_VALUE);
        return solve(triangle,0,0,dp);
    }
    public int solve(List<List<Integer>> triangle, int idx,int ind, int dp[][]){
        if(idx==triangle.size()-1) return triangle.get(idx).get(ind);
        if(dp[idx][ind]!=Integer.MAX_VALUE) return dp[idx][ind];
        int first = triangle.get(idx).get(ind) + solve(triangle,idx+1,ind,dp);
        int second = triangle.get(idx).get(ind) + solve(triangle,idx+1,ind+1,dp);
        return dp[idx][ind] = Math.min(first,second);
    }
}