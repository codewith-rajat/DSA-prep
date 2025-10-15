// https://leetcode.com/problems/shifting-letters-ii/description/

class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();
        int[] pref = new int[n+2];
        for(int i=0;i<shifts.length;i++){
            int l = shifts[i][0];
            int r = shifts[i][1];
            int v = shifts[i][2];
            if(v==0) {
                pref[l] = pref[l] - 1;
                pref[r+1] = pref[r+1] + 1;
            }else{
                pref[l] = pref[l] + 1;
                pref[r+1] = pref[r+1] - 1;
            }
        }
        for(int i=1;i<n;i++){
            pref[i] = pref[i-1] + pref[i];
        }
        char []c = s.toCharArray();
        for(int i=0;i<n;i++){
            int shift = ((s.charAt(i)-'a')+pref[i])%26;
            if(shift<0) shift += 26;
            char ch = (char)(shift+'a');
            c[i] = ch;
        }

        return new String(c);
    }
}