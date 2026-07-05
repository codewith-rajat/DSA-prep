// https://leetcode.com/problems/longest-repeating-character-replacement/description/

class Solution {
    public int characterReplacement(String s, int k) {
        int l=0, maxf=0, maxl=0;
        int f[] = new int[26];
        char[] ch = s.toCharArray();
        for(int r=0;r<s.length();r++){
            int idx = ch[r]-'A';
            f[idx]++;
            if(maxf<f[idx]) maxf = f[idx];
            if((r-l+1)-maxf>k){
                f[ch[l]-'A']--;
                l++;
            }
            if((r-l+1)>maxl) maxl = r-l+1;
        } 
        return maxl;
    }
}