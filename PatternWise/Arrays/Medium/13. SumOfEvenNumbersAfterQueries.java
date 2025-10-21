// https://leetcode.com/problems/sum-of-even-numbers-after-queries/description/

class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int sum = 0;
        int ans[] = new int[queries.length];
        for(int i:nums) if(i%2==0) sum += i;
        for(int i=0;i<queries.length;i++){
            int v = queries[i][0], idx = queries[i][1];
            if(nums[idx]%2==0) sum -= nums[idx];
            nums[idx] += v;
            if(nums[idx]%2==0) sum += nums[idx];
            ans[i] = sum;
        } 
        return ans;
    }
}