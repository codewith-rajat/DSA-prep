// https://leetcode.com/problems/divide-an-array-into-subarrays-with-minimum-cost-i/description/?envType=daily-question&envId=2026-02-01
// lc 3010

class Solution {
    public int minimumCost(int[] nums) {
        int n = nums.length, min = Integer.MAX_VALUE, smin = Integer.MAX_VALUE;
        for(int i=1;i<n;i++){
            if(nums[i]<min){
                smin = min;
                min = nums[i];
            }else if(nums[i]<smin) smin = nums[i];
        }
        return nums[0]+min+smin;
    }
}