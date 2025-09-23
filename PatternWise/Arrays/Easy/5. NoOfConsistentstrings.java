// https://leetcode.com/problems/count-the-number-of-consistent-strings

class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        int freq[] = new int[26];
        for(int i=0;i<allowed.length();i++){
            freq[allowed.charAt(i)-'a']++;
        }
        int ans = 0;
        for(String i : words){
            int l = 0;
            for(int j=0;j<i.length();j++){
                if(freq[i.charAt(j)-'a']>0) l++;
            }
            if(l==i.length()) ans++;
        }
        return ans;
    }
}