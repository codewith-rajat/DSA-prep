// https://leetcode.com/problems/minimum-string-length-after-removing-substrings/description/
// leetcode 2696
class Solution {
    public int minLength(String s) {
        Stack<Character> st = new Stack<>();
        for(int i=0;i<s.length();i++){
            if(!st.isEmpty() && 
                ((st.peek()=='A' && s.charAt(i)=='B') ||
                (st.peek()=='C' && s.charAt(i)=='D'))) st.pop();
            else st.push(s.charAt(i));
        }
        return st.size();
    }
}

class Solution {
    public int minLength(String s) {
        StringBuilder sb = new StringBuilder();
        for(char ch : s.toCharArray()){
            if(sb.length()>0 && ( 
                (sb.charAt(sb.length()-1)=='A' && ch=='B') ||
                (sb.charAt(sb.length()-1)=='C' && ch=='D'))) 
                    sb.deleteCharAt(sb.length()-1);
            else sb.append(ch);
        }
        return sb.length();
    }
}