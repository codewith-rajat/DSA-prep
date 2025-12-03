// https://leetcode.com/problems/find-all-anagrams-in-a-string/description/
// https://www.geeksforgeeks.org/problems/count-occurences-of-anagrams5839/1

class Solution {
    public List<Integer> findAnagrams(String txt, String pat) {
        int freq[] = new int[26];
        for(char ch:pat.toCharArray()) freq[ch-'a']++;
        int l = 0, r = 0, n = txt.length();
        List<Integer> ans = new ArrayList<>();
        int fr[] = new int[26];
        while(r<n){
            char c = txt.charAt(r);
            fr[c-'a']++;
            if((r-l+1)>pat.length()){
                fr[txt.charAt(l)-'a']--;
                l++;
            }
            if((r-l+1)==pat.length()){
                if(check(freq,fr)) ans.add(l);
            }
            r++;
        }
        return ans;
    }
    public static boolean check(int[] a, int[] b){
        for(int i=0;i<26;i++){
            if(a[i]!=b[i]) return false;
        }
        return true;
    }
}