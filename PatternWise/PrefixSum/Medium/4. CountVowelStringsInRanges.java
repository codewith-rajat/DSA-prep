// https://leetcode.com/problems/count-vowel-strings-in-ranges/description/

class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int[] pref = new int[words.length+1];
        int c = 0,idx = 1;
        pref[0] = 0;
        for(String s:words){
            if(isVowel(s.charAt(0)) && isVowel(s.charAt(s.length()-1))){
                c++;
                pref[idx++] = c;
            }else pref[idx++] = c;
        }
        int res[] = new int[queries.length];
        int indx = 0;
        for(int[] a : queries){
            int i = a[0], j = a[1]+1;
            res[indx++] = pref[j] - pref[i];
        }
        return res;
    }
    public boolean isVowel(char ch){
        if("aeiou".indexOf(ch)!=-1)return true;
        return false;
    }
}