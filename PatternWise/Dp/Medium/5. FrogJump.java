// https://takeuforward.org/plus/dsa/problems/frog-jump

//memoization
class Solution{
    public int frogJump(int[] heights){
        int n = heights.length;
        int dp[] = new int[n];
        Arrays.fill(dp,-1);
        int ans = help(dp,heights,n-1);
        return ans;
    }
    public int help(int[] dp, int[] heights,int n){
        if(n==0) return 0;
        if(dp[n]!=-1) return dp[n];
        int left = help(dp,heights,n-1) + Math.abs(heights[n] - heights[n-1]);
        int right = Integer.MAX_VALUE;
        if(n>1) right = help(dp,heights,n-2) + Math.abs(heights[n] - heights[n-2]);
        return dp[n] = Math.min(left,right);
    }
}

//tabulation
class Solution{
    public int frogjump(int[] heights){
        int n = heights.length;
        int dp[] = new int[n];
        dp[0] = 0;
        for(int i=1;i<n;i++){
            int fs = dp[i-1] + Math.abs(heights[i] - heights[i-1]);
            int ss = Integer.MAX_VALUE;
            if(i>1) ss = dp[i-2] + Math.abs(heights[i] - heights[i-2]);
            dp[i] = Math.min(fs,ss);
        }
        return dp[n-1];
    }
}

//space optimisation
class Solution {
    public int frogJump(int[] heights) {
        int n = heights.length;
        int prev = 0;
        int prev2 = 0;
        for(int i=1;i<n;i++){
            int fs = prev + Math.abs(heights[i] - heights[i-1]);
            int ss = Integer.MAX_VALUE;
            if(i>1) ss = prev2 + Math.abs(heights[i] - heights[i-2]);
            int curri = Math.min(fs,ss);
            prev2 = prev;
            prev = curri;
        }
        return prev;
    }
}