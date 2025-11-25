// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/

class Solution {
    public int first(int [] nums,int target, int low, int high){
        int ans = -1;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(nums[mid]==target){
                ans = mid;
                high = mid-1;
            }
            else if(nums[mid]>target) high = mid - 1;
            else low = mid+1;
        }
        return ans;
    }
    public int last(int [] nums,int target, int low, int high){
        int ans = -1;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(nums[mid]==target){
                ans = mid;
                low = mid+1;
            }
            else if(nums[mid]>target) high = mid - 1;
            else low = mid+1;
        }
        return ans;
    }
    public int[] searchRange(int[] nums, int target) {
        int a = first(nums,target,0,nums.length-1);
        int b = last(nums,target,0,nums.length-1);
        return new int[] {a,b};
    }
}