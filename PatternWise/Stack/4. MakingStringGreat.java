// https://leetcode.com/problems/make-the-string-great/
// leetcode 1544
class Solution {
    public String makeGood(String s) {
        Stack<Character> st = new Stack<>();
        for(int i=0;i<s.length();i++){
            if(!st.isEmpty() && Math.abs(st.peek()-s.charAt(i))==32){
                st.pop();
                continue;
            }
            st.push(s.charAt(i));
        }
        StringBuilder sb = new StringBuilder();
        while(st.size()>0) sb.append(st.pop());
        return sb.reverse().toString();
    }
}