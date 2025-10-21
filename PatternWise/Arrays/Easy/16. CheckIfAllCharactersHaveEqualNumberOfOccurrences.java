// https://leetcode.com/problems/check-if-all-characters-have-equal-number-of-occurrences/description/

class Solution {
    public boolean areOccurrencesEqual(String s) {
        int n = s.length();
        System.out.print(n);
        int[] fre = new int[26];
        for(char ch : s.toCharArray()){
            fre[ch-'a']++; 
        }
        int common = 0;
        for(int f:fre){
            if(f>0){
                if(common==0) common = f;
                else if(f!=common) return false;
            }
        }
        return true;
    }
}