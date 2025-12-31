// https://leetcode.com/problems/combination-sum-iii/description/111

class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ls = new ArrayList<>();
        help(k,n,ls,new ArrayList(),1);
        return ls;
    }
    public void help(int k, int n, List<List<Integer>> ls, List<Integer> temp,int num){
        if(k==0 && n==0){
            ls.add(new ArrayList<>(temp));
            return;
        }
        if(k<0 || n<0 || num>9) return;
        temp.add(num);
        help(k-1,n-num,ls,temp,num+1);
        temp.remove(temp.size()-1);
        help(k,n,ls,temp,num+1);
    }
}