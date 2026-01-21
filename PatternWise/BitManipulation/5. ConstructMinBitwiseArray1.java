// https://leetcode.com/problems/construct-the-minimum-bitwise-array-i/
// leetcode 3314
class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int ans[] = new int[n];
        for(int i=0;i<n;i++){
            if(nums.get(i)==2){
                ans[i] = -1;
                continue;
            }
            ans[i] = Integer.MAX_VALUE;
            for(int j=1;j<nums.get(i);j++){
                if(( j | (j+1)) == nums.get(i)) ans[i] = Math.min(ans[i],j);
            }
            if(ans[i]==Integer.MAX_VALUE) ans[i] = -1; 
        }
        return ans;
    }
}