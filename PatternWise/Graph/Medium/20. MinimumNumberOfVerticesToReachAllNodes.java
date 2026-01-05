// https://leetcode.com/problems/minimum-number-of-vertices-to-reach-all-nodes/description/

class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        boolean [] incoming = new boolean[n];
        List<Integer> ls = new ArrayList<>();
        for(List<Integer> i : edges){
            incoming[i.get(1)] = true;
        }
        for(int i=0;i<n;i++){
            if(!incoming[i]) ls.add(i);
        }
        return ls;
    }
}