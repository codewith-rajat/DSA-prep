// https://leetcode.com/problems/longest-palindrome/

class Solution {
    public int longestPalindrome(String s) {
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        int c = 0;
        boolean hasOdd = false;
        for(int f : map.values()){
            if(f%2==0) c += f;
            else{
                c += f-1;
                hasOdd = true;
            } 
        }
        if(hasOdd) c+=1;
        return c;
    }
}