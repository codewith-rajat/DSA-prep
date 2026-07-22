// https://leetcode.com/problems/separate-black-and-white-balls/description/

class Solution {
    public long minimumSteps(String s) {
        int n = s.length(), j = n-1;
        long ans = 0;
        for(int i=n-1;i>=0;i--){
            if(s.charAt(i)=='1') {
                ans += Math.abs(j-i);
                j--;
            }
        }
        return ans;
    }
}