// https://www.geeksforgeeks.org/problems/longest-common-substring1452/1

// User function Template for Java

class Solution {
    public int longestCommonSubstr(String s1, String s2) {
        // code here
        int m = s1.length(), n = s2.length();
        int maxx = 0;
        int dp[][] = new int[m+1][n+1];
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(s1.charAt(i-1)!=s2.charAt(j-1)){
                    dp[i][j] = 0;
                }
                else {
                    dp[i][j] = dp[i-1][j-1]+1;
                    maxx = Math.max(maxx,dp[i][j]);
                }
            }
        }
        return maxx;
    }
}