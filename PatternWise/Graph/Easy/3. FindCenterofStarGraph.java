// https://leetcode.com/problems/find-center-of-star-graph/description

class Solution {
    public int findCenter(int[][] edges) {
        List<List<Integer>> ls = new ArrayList<>();
        int n = edges.length;
        for(int i=0;i<=n+1;i++){
            ls.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            ls.get(u).add(v);
            ls.get(v).add(u);
        }
        for(int i=1;i<=n+1;i++){
            if(ls.get(i).size()==n) return i;
        }
        return -1;
    }
}