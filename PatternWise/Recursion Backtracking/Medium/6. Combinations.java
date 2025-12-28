// https://leetcode.com/problems/combinations/description/

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ls = new ArrayList<>();
        help(n,k,1,ls,new ArrayList());
        return ls;
    }
    public void help(int n, int k, int num, List<List<Integer>> ls, List<Integer> temp){
        if(temp.size()==k){
            ls.add(new ArrayList<>(temp));
            return;
        }
        if(num>n) return;
        temp.add(num);
        help(n,k,num+1,ls,temp);
        temp.remove(temp.size()-1);
        help(n,k,num+1,ls,temp);
    }
}