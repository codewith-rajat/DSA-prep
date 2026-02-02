// https://leetcode.com/problems/subarray-sum-equals-k/
// lc 560

class Solution {
    public int subarraySum(int[] nums, int k) {
        int ans = 0, pref = 0;
        Map<Integer,Integer> mp = new HashMap<>();
        mp.put(0,1);
        for(int i=0;i<nums.length;i++){
            pref += nums[i];
            if(mp.containsKey(pref-k)) ans += mp.get(pref-k);
            mp.put(pref,mp.getOrDefault(pref,0)+1);
        }
        return ans;
    }
}