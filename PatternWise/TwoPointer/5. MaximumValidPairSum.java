// https://leetcode.com/problems/maximum-valid-pair-sum/

class Solution {
    public int maxValidPairSum(int[] nums, int k) {
        int i = nums[0];
        int ans=0;
        for(int j=k;j<nums.length;j++){
            i = Math.max(i, nums[j-k]);
            ans = Math.max(ans, i+nums[j]);
        }
        return ans;
    }
}