// https://leetcode.com/problems/find-players-with-zero-or-one-losses/

class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        int n = matches.length;
        int[] lost = new int[100001];
        int[] winn = new int[100001];
        for(int i=0;i<n;i++){
            int win = matches[i][0];
            int lose = matches[i][1];
            lost[lose]++;
            winn[win]++;
        }
        List<Integer> a2 = new ArrayList<>();
        for(int i=0;i<lost.length;i++){
            if(lost[i]==1) a2.add(i);
        }
        List<Integer> a1 = new ArrayList<>();
        for(int i=0;i<lost.length;i++){
            if(lost[i]==0 && winn[i]!=0) a1.add(i);
        }
        List<List<Integer>> ls = new ArrayList<>();
        ls.add(new ArrayList(a1));
        ls.add(new ArrayList(a2));
        return ls;
    }
}