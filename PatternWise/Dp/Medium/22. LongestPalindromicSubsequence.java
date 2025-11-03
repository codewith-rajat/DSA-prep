// https://leetcode.com/problems/longest-palindromic-subsequence/

class Solution {
    public int longestPalindromeSubseq(String s) {
        int m = s.length();
        int dp[] = new int[m+1];
        for(int i=1;i<=m;i++){
            int prev = 0;
            for(int j=1;j<=m;j++){
                int temp = dp[j];
                if(s.charAt(i-1)!=s.charAt(m-j)) dp[j] = Math.max(dp[j],dp[j-1]);
                else dp[j] = prev + 1;
                prev = temp;
            }
        }
        return dp[m];
    }
}