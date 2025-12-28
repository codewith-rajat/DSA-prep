// https://leetcode.com/problems/maximum-score-of-a-split/description/

class Solution {
    public long maximumScore(int[] nums) {
        int n = nums.length;
        long pref[] = new long[n];
        pref[0] = nums[0];
        for(int i=1;i<n;i++){
            pref[i] = pref[i-1] + nums[i];
        }
        long sufMin[] = new long[n];
        sufMin[n-1] = nums[n-1];
        for(int i=n-2;i>=0;i--){
            sufMin[i] = Math.min(sufMin[i+1],nums[i]);
        }
        long maxx = Integer.MIN_VALUE;
        for(int i=0;i<n-1;i++){
            maxx = Math.max(maxx,pref[i]-sufMin[i+1]);
        }
        return maxx;
    }
}