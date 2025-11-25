// https://leetcode.com/problems/minimum-number-of-chairs-in-a-waiting-room/description/

class Solution {
    public int minimumChairs(String s) {
        int count = 0,ans = Integer.MIN_VALUE;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='E') count ++;
            else count--;
            ans = Math.max(ans,count);
        }
        return ans;
    }
}