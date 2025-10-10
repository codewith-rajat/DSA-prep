// https://leetcode.com/problems/keyboard-row/description/

class Solution {
    public String[] findWords(String[] words) {
        int n = words.length;
        String[]  temp = new String[n];
        for(int i=0;i<n;i++){
            temp[i] = words[i].toLowerCase();
        }
        List<String> ls = new ArrayList<>();
        String fr = "qwertyuiop";
        String sr = "asdfghjkl";
        String tr = "zxcvbnm";
        for(int i=0;i<n;i++){
            String ch = temp[i];
            int c = 0;
            if(fr.indexOf(ch.charAt(0))!=-1){
                c++;
                for(int j=1;j<ch.length();j++){
                    if(fr.indexOf(ch.charAt(j))!=-1) c++;
                }
            }
            else if(sr.indexOf(ch.charAt(0))!=-1){
                c++;
                for(int j=1;j<ch.length();j++){
                    if(sr.indexOf(ch.charAt(j))!=-1) c++;
                }
            }
            else if(tr.indexOf(ch.charAt(0))!=-1){
                c++;
                for(int j=1;j<ch.length();j++){
                    if(tr.indexOf(ch.charAt(j))!=-1) c++;
                }
            }
            if(c==ch.length()) ls.add(words[i]);
        }
        String[] ans = new String[ls.size()];
        for(int i=0;i<ls.size();i++){
            ans[i] = ls.get(i);
        }
        return ans;
    }
}