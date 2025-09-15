// https://leetcode.com/problems/is-subsequence/description/

class Solution {
    public boolean isSubsequence(String s, String t) {
        int n = t.length();
        int m = s.length();
        if(n<m) return false;
        int i=0;
        int j=0;
        while(i<m && j<n){
            if(s.charAt(i)==t.charAt(j)){
                i++;
                j++;
            }
            else j++;
        }
        return i==m;
    }
}