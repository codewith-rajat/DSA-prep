// https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/5. 

class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ls = new ArrayList<>();
        if(digits.length()==0) return ls;
        Map<Character,String> mp = new HashMap<>();
        mp.put('2',"abc");
        mp.put('3',"def");
        mp.put('4',"ghi");
        mp.put('5',"jkl");
        mp.put('6',"mno");
        mp.put('7',"pqrs");
        mp.put('8',"tuv");
        mp.put('9',"wxyz");
        help(0,mp,ls,digits,digits.length(),new StringBuilder());
        return ls;
    }
    public void help(int idx, Map<Character,String> mp, List<String> ls, String digits, int n, StringBuilder curr){
        if(n==curr.length()){
            ls.add(curr.toString());
            return;
        }
        String letters = mp.get(digits.charAt(idx));
        for(char ch : letters.toCharArray()){
            curr.append(ch);
            help(idx+1,mp,ls,digits,n,curr);
            curr.deleteCharAt(curr.length()-1);
        }
    }
}