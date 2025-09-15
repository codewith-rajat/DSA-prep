// https://leetcode.com/problems/find-most-frequent-vowel-and-consonant/description

class Solution {
    public int maxFreqSum(String s) {
        int vc = 0;
        int cc = 0;
        int freq[] = new int[256];
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            freq[ch-'a']++;
            if("aeiou".indexOf(ch)!=-1){
                vc = Math.max(freq[ch-'a'],vc);
            }
            else{
                cc = Math.max(freq[ch-'a'],cc);
            }
        }
        return vc+cc;
    }
}