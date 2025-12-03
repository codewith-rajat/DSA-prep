// https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/description/

class Solution {
    public int maxVowels(String s, int k) {
        int maxcount = 0,count = 0,l=0,r=0,n=s.length();
        while(r<n){
            char ch = s.charAt(r);
            if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u') count++;
            if((r-l+1)>k){
                if(s.charAt(l)=='a'||s.charAt(l)=='e'||s.charAt(l)=='i'||s.charAt(l)=='o'||s.charAt(l)=='u') count--;
                l++;
            }
            if((r-l+1)==k) maxcount = Math.max(maxcount,count);
            r++;
        }
        return maxcount;
    }
}