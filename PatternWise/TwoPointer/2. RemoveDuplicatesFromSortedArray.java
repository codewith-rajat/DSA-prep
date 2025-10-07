// https://leetcode.com/problems/remove-duplicates-from-sorted-array

class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if(n==1) return nums[0];
        int i = 0;
        int j = 1;
        while(j<n){
            if(nums[i]==nums[j]) j++;
            else nums[++i] = nums[j++];
        }
        return i+1;
    }
}