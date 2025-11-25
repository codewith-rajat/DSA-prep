// https://leetcode.com/problems/special-array-with-x-elements-greater-than-or-equal-x/

class Solution {
    public int specialArray(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        for(int i=1;i<=n;i++){
            int temp = n;
            int l = 0, r = nums.length-1;
            while(l<=r){
                int mid = l + (r-l)/2;
                if(nums[mid]>=i){
                    temp = mid;
                    r = mid - 1;
                }else l = mid + 1;
            }
            if(i==(n-temp)) return i; 
        }
        return -1;
    }
}