// https://leetcode.com/problems/find-the-winner-of-the-circular-game/description/
// leetcode 1823  

class Solution {
    public int findTheWinner(int n, int k) {
        List<Integer> ls = new ArrayList<>();
        for(int i=1;i<=n;i++) ls.add(i);
        help(ls,k,0);
        return ls.get(0);
    }
    public void help(List<Integer> ls, int k, int idx){
        if(ls.size()==1) return;
        idx = (idx+k-1)%ls.size();
        ls.remove(idx);
        help(ls,k,idx);
    }
}