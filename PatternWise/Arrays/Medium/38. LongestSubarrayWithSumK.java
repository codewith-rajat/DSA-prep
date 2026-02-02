// https://www.geeksforgeeks.org/problems/longest-sub-array-with-sum-k0809/1
// gfg 

class Solution {
    public int longestSubarray(int[] arr, int k) {
        // code here
        Map<Integer,Integer> mp = new HashMap<>();
        int res = 0, pref = 0, n = arr.length;
        for(int i=0;i<n;i++){
            pref += arr[i];
            if(pref==k) res = i + 1;
            else if(mp.containsKey(pref-k)) res = Math.max(res,i-mp.get(pref-k));
            if(!mp.containsKey(pref)) mp.put(pref,i);
        }
        return res;
    }
}
