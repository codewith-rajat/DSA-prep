// https://leetcode.com/problems/number-of-longest-increasing-subsequence/description/

class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n];
        int count[] = new int[n];
        Arrays.fill(count,1);
        Arrays.fill(dp,1);
        int max = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    if(dp[i]<dp[j]+1){
                        dp[i] = dp[j]+1;
                        count[i] = count[j];
                    }
                    else if(dp[i]==dp[j]+1) count[i] = count[i] + count[j];
                }
            }
            max = Math.max(max,dp[i]);
        }
        int ans = 0;
        for(int i=0;i<n;i++){
            if(dp[i]==max) ans += count[i];
        }
        return ans;
    }
}