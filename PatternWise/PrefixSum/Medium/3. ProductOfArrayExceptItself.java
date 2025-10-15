// https://leetcode.com/problems/product-of-array-except-self/

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int left[] = new int[n];
        int right[] = new int[n];
        int p  = 1;
        for(int i=0;i<n;i++){
            left[i] = p * nums[i];
            p = p * nums[i];
        }
        p=1;
        for(int i=n-1;i>=0;i--){
            right[i] = p * nums[i];
            p = p * nums[i]; 
        }
        for(int i=0;i<n;i++){
            if(i==0) nums[i] = right[i+1];
            else if(i==n-1) nums[i] = left[i-1];
            else nums[i] = left[i-1] * right[i+1]; 
        }
        return nums;
    }
}