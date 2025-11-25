// https://leetcode.com/problems/count-asterisks/description/

class Solution {
    public int countAsterisks(String s) {
        int c = 0;
        int a = 0;
        for(int i=0;i<s.length();i++){
            if(a%2==0){
                if(s.charAt(i)=='*') c++;
            }
            if(s.charAt(i)=='|') a++;
        }
        return c;
    }
}