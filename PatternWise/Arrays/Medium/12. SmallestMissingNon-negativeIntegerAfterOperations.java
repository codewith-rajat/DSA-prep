// https://leetcode.com/problems/smallest-missing-non-negative-integer-after-operations/

class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        int freq[] = new int[value];
        for(int i:nums) {
            int mod = ((i%value)+value)%value;
            freq[mod]++;
        }
        int mex = 0;
        while(freq[mex%value]>0){
            freq[mex%value]--;
            mex++;
        }
        return mex;
    }
}