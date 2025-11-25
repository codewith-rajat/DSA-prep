// https://leetcode.com/problems/minimum-string-length-after-balanced-removals/description/

class Solution {
    public int minLengthAfterRemovals(String s) {
        int a = 0,b = 0;
        char ch[] = s.toCharArray();
        for(char c : ch){
            if(c=='a') a++;
            else b++;
        }
        return Math.abs(a-b);
    }
}