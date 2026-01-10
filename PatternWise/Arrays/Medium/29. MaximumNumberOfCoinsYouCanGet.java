// https://leetcode.com/problems/maximum-number-of-coins-you-can-get/description/

class Solution {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int ans = 0, n = piles.length;
        for(int i = n-2,count = 0;count<n/3;i-=2,count++){
            ans += piles[i];
        }
        return ans;
    }
}