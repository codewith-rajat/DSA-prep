// https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/description/

class Solution {
    public int numberOfSubstrings(String s) {
        int l = 0, r = 0, n = s.length(), ans = 0;
        int freq[] = new int[3];
        while(r<n){
            char ch = s.charAt(r);
            freq[ch-'a']++;
            while(freq[0]>0 && freq[1]>0 && freq[2]>0){
                ans += n-r;
                freq[s.charAt(l)-'a']--;
                l++;
                
            }
            r++;
        }
        return ans;
    }
}


class Solution {
    public int numberOfSubstrings(String s) {
        int l = 0, r = 0, n = s.length(), ans = 0;
        HashMap<Character,Integer> mp = new HashMap<>();
        while(r<n){
            char ch = s.charAt(r);
            mp.put(ch,mp.getOrDefault(ch,0)+1);
            if(mp.size()==3){
                mp.put(s.charAt(l),mp.getOrDefault(s.charAt(l),0)-1);
                if(mp.get(s.charAt(l))==0) mp.remove(s.charAt(l));
                ans += r-l;
                l++;
                
            }
            r++;
        }
        return ans;
    }
}