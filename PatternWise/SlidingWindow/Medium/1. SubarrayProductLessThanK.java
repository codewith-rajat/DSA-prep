// https://leetcode.com/problems/subarray-product-less-than-k/description/

class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k<=1) return 0;
        int n = nums.length;
        int i=0,j=0,c=0,p=1;
        while(j<n){
            p = p * nums[j];
            while(p>=k){
                p = p/nums[i];
                i++; 
            }
            c += j-i+1;
            j++;
        }
        return c;
    }
}