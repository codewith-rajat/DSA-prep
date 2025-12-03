// https://leetcode.com/problems/count-elements-with-at-least-k-greater-values/description/

class Solution {
    public int countElements(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        if(k==0) return n;
        if(nums[0]==nums[n-1]) return 0;
        int ans = 0;
        for(int i=0;i<n-1;i++){
            int idx = find(nums,i);
            if(idx!=-1 && n-idx>=k) ans++;
        }
        return ans;
    }
    public int find(int[] nums,int i){
        int l=i,r=nums.length-1,ans=-1;
        while(l<=r){
            int mid = l + (r-l)/2;
            if(nums[mid]>nums[i]){
                r=mid-1;
                ans=mid;
            }else l=mid+1;
        }
        return ans;
    }
}