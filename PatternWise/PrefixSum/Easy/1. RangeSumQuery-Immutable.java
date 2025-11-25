// https://leetcode.com/problems/range-sum-query-immutable/description/

class NumArray {
    int pref[];
    public NumArray(int[] nums) {
        pref = nums;
        for(int i=1;i<pref.length;i++) pref[i] += pref[i-1];
    }
    
    public int sumRange(int left, int right) {
        if(left==0) return pref[right];
        return pref[right] - pref[left-1];
    }
}