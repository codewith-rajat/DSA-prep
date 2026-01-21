// https://leetcode.com/problems/construct-the-minimum-bitwise-array-ii/description/?envType=daily-question&envId=2026-01-21
// leetcode 3315
class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int ans[] = new int[n];
        for(int i=0;i<n;i++){
            int p = nums.get(i);
            if(p==2){
                ans[i] = -1;
                continue;
            }
            int temp = p;
            int trailingOnes = 0;
            while((temp & 1) == 1){
                trailingOnes++;
                temp >>= 1;
            }
            ans[i] = p - (1 << (trailingOnes - 1));
        }
        return ans;
    }
}