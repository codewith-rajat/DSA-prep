// https://leetcode.com/problems/maximize-happiness-of-selected-children/?envType=daily-question&envId=2025-12-25

class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        long ans = 0;
        int n = happiness.length;
        Arrays.sort(happiness);
        for(int i=n-1;i>=n-k;i--){
            happiness[i] = Math.max(0,happiness[i]-(n-i-1));
            ans += happiness[i];
        }
        return ans;
    }
}