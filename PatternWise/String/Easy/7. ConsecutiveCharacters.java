// https://leetcode.com/problems/consecutive-characters/description/

class Solution {
    public int maxPower(String s) {
        int count = 1, maxx = 1, n = s.length();
        for(int i=1;i<n;i++){
            if(s.charAt(i-1)==s.charAt(i)) {
                count++;
                maxx = Math.max(maxx,count);
            }else {
                count = 1;
            }
        }
        return maxx;
    }
}