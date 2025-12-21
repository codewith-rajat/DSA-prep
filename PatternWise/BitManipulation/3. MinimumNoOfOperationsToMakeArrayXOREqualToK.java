// https://leetcode.com/problems/minimum-number-of-operations-to-make-array-xor-equal-to-k/description/

class Solution {
    public int minOperations(int[] nums, int k) {
        int xor = 0;
        for(int i:nums) xor ^= i;
        xor ^= k;
        return Integer.bitCount(xor);
    }
}