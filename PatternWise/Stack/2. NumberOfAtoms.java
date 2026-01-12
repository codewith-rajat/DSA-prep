// https://leetcode.com/problems/number-of-atoms/description/

class Solution {
    public String countOfAtoms(String formula) {
        Stack<Map<String,Integer>> st = new Stack<>();
        st.push(new HashMap<>());
        int n = formula.length(), i = 0;
        while(i<n){
            if(formula.charAt(i)=='('){
                st.push(new HashMap<>());
                i++;
            }else if(formula.charAt(i)==')'){
                Map<String,Integer> mp = st.pop();
                i++;
                int start = i;
                while(i<n && Character.isDigit(formula.charAt(i))) i++;
                int val = 0;
                while(start<i) val = val * 10 + formula.charAt(start++)-'0';
                if(val==0) val = 1;
                for(String key : mp.keySet()){
                    st.peek().put(key,st.peek().getOrDefault(key,0)+mp.get(key)*val);
                }
            }else{
                int start = i;
                i++;
                while(i<n && Character.isLowerCase(formula.charAt(i))) i++;
                String atom = formula.substring(start,i);
                start = i;
                while(i<n && Character.isDigit(formula.charAt(i))) i++;
                int count = 0;
                while(start<i) count = count * 10 + formula.charAt(start++) -'0';
                if(count==0) count = 1;
                st.peek().put(atom,st.peek().getOrDefault(atom,0)+count);
            }
        }
        Map<String,Integer> result = st.pop();
        List<String> ls = new ArrayList<>(result.keySet());
        Collections.sort(ls);
        StringBuilder sb = new StringBuilder();
        for(String s : ls){
            sb.append(s);
            int count = result.get(s);
            if(count>1) sb.append(count);
        }
        return sb.toString();
    }
}