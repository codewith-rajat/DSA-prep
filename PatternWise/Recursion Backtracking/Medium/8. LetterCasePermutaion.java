// https://leetcode.com/problems/letter-case-permutation/description/

class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> ls = new ArrayList<>();
        help(s,0,new StringBuilder(),ls);
        return ls;
    }
    public void help(String s,int idx,StringBuilder sb,List<String> ls){
        if(idx==s.length()){
            ls.add(sb.toString());
            return;
        }
        char ch = s.charAt(idx);
        if(isDigit(ch)){
            sb.append(ch);
            help(s,idx+1,sb,ls);
            sb.deleteCharAt(sb.length()-1);
        }
        else{
            sb.append(Character.toLowerCase(ch));
            help(s,idx+1,sb,ls);
            sb.deleteCharAt(sb.length()-1);
            sb.append(Character.toUpperCase(ch));
            help(s,idx+1,sb,ls);
            sb.deleteCharAt(sb.length()-1);
        }
    }
    public boolean isDigit(char ch){
        if(ch>='0' && ch<='9') return true;
        return false;
    }
}