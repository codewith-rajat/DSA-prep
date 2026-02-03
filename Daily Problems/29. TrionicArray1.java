// https://leetcode.com/problems/trionic-array-i/description/?envType=daily-question&envId=2026-02-03
// lc 36377

class Solution {
    public boolean isTrionic(int[] nums) {
        int state = 0, n = nums.length;
        for(int i=0;i<n-1;i++){
            if(state==0){
                if(nums[i]<nums[i+1]);
                else if(i>0 && nums[i]>nums[i+1]) state = 1;
                else return false;
            }else if(state==1){
                if(nums[i]>nums[i+1]);
                else if(nums[i]<nums[i+1]) state = 2;
                else return false;
            }else if(state==2){
                if(nums[i]<nums[i+1]);
                else return false;
            }
        }
        return state==2;
    }
}