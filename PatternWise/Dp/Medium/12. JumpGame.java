// https://leetcode.com/problems/jump-game/description/

//recursion + memo
class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        Boolean dp[] = new Boolean[n];
        return helper(nums,n,0,dp);
    }
    public boolean helper(int []nums, int n, int idx,Boolean []dp){
        if(idx==n-1) return true;
        if(dp[idx]!=null) return dp[idx];
        for(int i=1;i<=nums[idx];i++){
            if(helper(nums,n,idx+i,dp)) return dp[idx] = true;
        }
    return dp[idx] = false;
    }
}

//tabulation
class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        boolean dp[] = new boolean[n];
        dp[0] = true;
        for(int i=1;i<n;i++){
            for(int j=i-1;j>=0;j--){
                if(dp[j]==true && j+nums[j]>=i){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n-1];
    }
}

//optimised
class Solution {
    public boolean canJump(int[] nums) {
        int maxReachable = 0;
        for(int i=0;i<nums.length;i++){
            if(i>maxReachable) return false;
            maxReachable = Math.max(maxReachable,i+nums[i]);
        }
        return true;
    }
}