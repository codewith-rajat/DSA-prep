
// https://leetcode.com/problems/number-of-subarrays-that-match-a-pattern-i/description/
class Solution {
    public int countMatchingSubarrays(int[] nums, int[] pattern) {
        int ans = 0;
        int n = nums.length, m = pattern.length;
        for (int i = 0; i + m < n; i++) {
            int matched = 0;
            for (int k = 0; k < m; k++) {
                if (pattern[k] == 1 && nums[i + k + 1] > nums[i + k]) matched++;
                else if (pattern[k] == 0 && nums[i + k + 1] == nums[i + k]) matched++;
                else if (pattern[k] == -1 && nums[i + k + 1] < nums[i + k]) matched++;
                else break; 
            }
            if (matched == m) ans++;
        }
        return ans;
    }
}