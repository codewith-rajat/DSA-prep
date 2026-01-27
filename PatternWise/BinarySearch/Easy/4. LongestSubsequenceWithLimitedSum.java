// https://leetcode.com/problems/longest-subsequence-with-limited-sum/description/
// leetcode 2389

class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int n = nums.length;
        int pref[] = new int[n];
        pref[0] = nums[0];
        for(int i=1;i<n;i++) pref[i] = pref[i-1] + nums[i];
        int answer[] = new int[queries.length];
        for(int i=0;i<queries.length;i++){
            int l = 0, r = n-1;
            while(l<=r){
                int mid = l + (r-l)/2;
                if(pref[mid]<=queries[i]){
                    answer[i] = mid+1;
                    l++;
                }else r--;
            }
        }
        return answer;  
    }
}