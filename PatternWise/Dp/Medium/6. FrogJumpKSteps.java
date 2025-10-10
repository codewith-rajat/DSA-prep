class Solution{
    public int frogJump(int[] heights, int k){
        int n = heights.length;
        int dp[] = new int[n];
        Arrays.fill(dp,-1);
        return help(dp,heights,n-1,k);
    }
    public int help(int []dp, int[] heights, int i, int k){
        if(i==0) return 0;
        if(dp[i]!=-1) return dp[i];
        int minsteps = Integer.MAX_VALUE;
        for(int j = 1;j<=k;j++){
            if(i-j>=0) {
                int jump = help(dp,heights,i-j,k) + Math.abs(heights[i] - heights[i-j]);
                minsteps = Math.min(minsteps,jump);
            }
        }
        return dp[i] = minsteps;
    }
}
