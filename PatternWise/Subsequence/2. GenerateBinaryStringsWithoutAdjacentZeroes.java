// https://leetcode.com/problems/generate-binary-strings-without-adjacent-zeros/description/

class Solution {
    public List<String> validStrings(int n) {
        List<String> ls = new ArrayList<>();
        help(n,ls,"",1);
        return ls;
    }
    public void help(int n, List<String> ls, String curr, int prev){
        if(curr.length()==n){
            ls.add(curr);
            return;
        }
        help(n,ls,curr+"1",1);
        if(prev!=0){
            help(n,ls,curr+"0",0);
        }
    }
}