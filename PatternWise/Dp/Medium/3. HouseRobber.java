// https://leetcode.com/problems/house-robber

class Solution {
    int findMaxSum(int arr[]) {
        // code here
        int n = arr.length;
        if(n==1) return arr[0];
        if(n==2) return Math.max(arr[0],arr[1]);
        int dp[] = new int[n];
        Arrays.fill(dp,-1);
        dp[0] = arr[0];
        dp[1] = Math.max(arr[0],arr[1]);
        for(int i=2;i<n;i++){
            dp[i] = Math.max(dp[i-2] + arr[i],dp[i-1]); 
        }
        return dp[n-1];
    }
}