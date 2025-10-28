// https://leetcode.com/problems/target-sum/description/

class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int totsum = 0;
        for(int i:nums) totsum += i;
        if(Math.abs(target)>totsum) return 0;
        if((target+totsum)%2==1) return 0;
        int dp[]  = new int[((target+totsum)/2)+1];
        dp[0] = 1;
        for(int i=0;i<n;i++){
            for(int j=(target+totsum)/2;j>=nums[i];j--){
                dp[j] = dp[j] + dp[j-nums[i]];
            }
        }
        return dp[(target+totsum)/2];
    }
}