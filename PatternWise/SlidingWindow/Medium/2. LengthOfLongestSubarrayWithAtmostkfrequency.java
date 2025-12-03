// https://leetcode.com/problems/length-of-longest-subarray-with-at-most-k-frequency/description/

class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int l =0, r= 0,n = nums.length, maxlen = 0;
        HashMap<Integer,Integer> mp = new HashMap<>();
        while(r<n){
            mp.put(nums[r],mp.getOrDefault(nums[r],0)+1);
            while(mp.get(nums[r])>k){
                mp.put(nums[l],mp.getOrDefault(nums[l],0)-1);
                l++;
            }
            maxlen = Math.max(maxlen,r-l+1);
            r++;
        }
        return maxlen;
    }
}