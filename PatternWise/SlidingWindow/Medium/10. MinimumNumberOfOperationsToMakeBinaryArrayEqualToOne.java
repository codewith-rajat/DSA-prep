// https://leetcode.com/problems/minimum-operations-to-make-binary-array-elements-equal-to-one-i/description/?envType=daily-question&envId=2025-03-19
// leetcode 3191
class Solution {
    public int minOperations(int[] nums) {
        int ans = 0, n = nums.length;
        for(int i=0;i<=n-3;i++){
            if(nums[i]==0) {
                nums[i] = 1;
                nums[i+1] = nums[i+1] == 0 ? 1 : 0;
                nums[i+2] = nums[i+2] == 0 ? 1 : 0;
                ans++;
            }
        }
        for(int i=0;i<n;i++) if(nums[i]!=1) return -1;
        return ans;
    }
}