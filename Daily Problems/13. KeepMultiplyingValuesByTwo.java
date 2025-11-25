// https://leetcode.com/problems/keep-multiplying-found-values-by-two/description/?envType=daily-question&envId=2025-11-19
class Solution {
    public int findFinalValue(int[] nums, int original) {
        Arrays.sort(nums);
        return find(0,nums,original);
    }
    public int find(int idx,int[]nums,int n){
        for(int i=idx;i<nums.length;i++){
            if(nums[i]==n){
                return find(idx+1,nums,n*2);
            }
        }
        return n;
    }
}