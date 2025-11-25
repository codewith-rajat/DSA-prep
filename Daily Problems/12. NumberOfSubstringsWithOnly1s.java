// https://leetcode.com/problems/number-of-substrings-with-only-1s/description/?envType=daily-question&envId=2025-11-16

class Solution {
    public int numSub(String s) {
        long ans = 0,count=0;
        for(char ch:s.toCharArray()){
            if(ch=='1') count++;
            else{
                ans += count*(count+1)/2;
                count=0;
            }
        }
        ans += count*(count+1)/2;
        return (int)(ans%(int)(1e9+7));
    }
}