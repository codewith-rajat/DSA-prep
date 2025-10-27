// https://leetcode.com/problems/check-if-digits-are-equal-in-string-after-operations-i/description/

class Solution {
    public boolean hasSameDigits(String s) {
        while(s.length()>2){
            StringBuilder sb = new StringBuilder();
            int j = 0;
            for(int i=1;i<s.length();i++){
                sb.append((s.charAt(j) + s.charAt(i))%10);
                j++;
            }
            s = sb.toString();
        }
        return s.charAt(0)==s.charAt(1);
    }
}