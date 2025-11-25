// https://leetcode.com/problems/maximum-number-of-operations-to-move-ones-to-the-end/description/

class Solution {
    public int maxOperations(String s) {
        int one = 0, res = 0;
        char ch[] = s.toCharArray();
        for(int i=0;i<ch.length;i++){
            if(ch[i]=='1') one++;
            else if(i>0 && ch[i-1]=='1') res += one;
        }
        return res;
    }
}