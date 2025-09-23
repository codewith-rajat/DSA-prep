// https://leetcode.com/problems/counting-words-with-a-given-prefix

class Solution {
    public int prefixCount(String[] words, String pref) {
        int count=0;
        for(int i=0;i<words.length;i++){
            if(words[i].startsWith(pref)){
                count++;
            }
        }
        return count;
    }
}class Solution {
    public int prefixCount(String[] words, String pref) {
        int ans = 0;
        for(String i:words){
            if(i.length()>=pref.length()){
                boolean match = true;
                for(int j=0;j<pref.length();j++){
                    if(pref.charAt(j)!=i.charAt(j)){
                        match = false;
                        break;
                    }
                }
                if(match) ans++;
            }
        }
        return ans;
    }
}