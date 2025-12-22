// https://leetcode.com/problems/maximum-substrings-with-distinct-start/description/

class Solution {
    public int maxDistinct(String s) {
        int freq[] = new int[26];
        for(char ch : s.toCharArray()){
            freq[ch-'a']++;
        }
        int ans = 0;
        for(int i=0;i<26;i++){
            if(freq[i]>0) ans++;
        }
        return ans;
    }
}