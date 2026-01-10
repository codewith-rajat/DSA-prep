// https://leetcode.com/problems/number-of-laser-beams-in-a-bank/description/?envType=problem-list-v2&envId=array

class Solution {
    public int numberOfBeams(String[] bank) {
        int ans = 0, count = 0;
        String s = bank[0];
        for(char ch : s.toCharArray()) if(ch=='1') count++;
        for(int i=1;i<bank.length;i++){
            String t = bank[i];
            int c = 0;
            for(char ch : t.toCharArray()) if(ch=='1') c++;
            ans += count * c;
            if(c!=0) count = c;
        }
        return ans;
    }
}