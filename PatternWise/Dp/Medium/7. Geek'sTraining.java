// https://www.geeksforgeeks.org/problems/geeks-training/1

// User function Template for Java

class Solution {
    public int maximumPoints(int arr[][]) {
        // code here
        int n = arr.length;
        int m = arr[0].length;
        int[][] dp = new int[n][m];
        
        for(int j=0;j<m;j++){
            dp[0][j] = arr[0][j];
        }
        for(int i=1;i<n;i++){
            for(int j=0;j<m;j++){
                int max = 0;
                for(int k=0;k<m;k++){
                    if(j!=k) max = Math.max(max,dp[i-1][k]);
                }
                dp[i][j] = max + arr[i][j];
            }
        }
        int max = 0;
        for(int j=0;j<m;j++){
            max = Math.max(max,dp[n-1][j]);
        }
        return max;
    }
}