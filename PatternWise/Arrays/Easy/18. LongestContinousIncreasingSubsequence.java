// https://leetcode.com/problems/longest-continuous-increasing-subsequence/description/

class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int count=1;
        int maxCount=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i-1]<nums[i]){
                count++;
                maxCount=Math.max(count,maxCount);
            }
            else 
                count=1;    
        }
        return maxCount;
    }
}