// https://leetcode.com/problems/remove-all-occurrences-of-a-substring/description/

class Solution {
    public String removeOccurrences(String s, String part) {
        while(s.length()>0){
            int ind=s.indexOf(part);
            if(ind==-1) return s;
            String snew = s.substring(0,ind) + s.substring(ind+part.length(),s.length());
            s=snew;
        }
        return "";
    }
}