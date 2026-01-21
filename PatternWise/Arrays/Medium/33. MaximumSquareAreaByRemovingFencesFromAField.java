// https://leetcode.com/problems/maximum-square-area-by-removing-fences-from-a-field/
// leetcode 2975
class Solution {
    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        List<Integer> hls = new ArrayList<>();
        List<Integer> vls = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for(int i : hFences) hls.add(i);
        hls.add(1);
        hls.add(m);
        for(int i : vFences) vls.add(i);
        vls.add(1);
        vls.add(n);
        long ans = 0;
        for(int i=0;i<hls.size();i++){
            for(int j=i+1;j<hls.size();j++){
                set.add(Math.abs(hls.get(j)-hls.get(i)));
            }
        }
        for(int i=0;i<vls.size();i++){
            for(int j=i+1;j<vls.size();j++){
                int val = Math.abs(vls.get(j)-vls.get(i));
                if(set.contains(val)) ans = Math.max(ans,val);
            }
        }
        long MOD = 1_000_000_007;
        return ans == 0 ? -1 : (int)((ans * ans) % MOD);
    }
}