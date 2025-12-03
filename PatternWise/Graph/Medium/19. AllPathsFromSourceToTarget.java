// https://leetcode.com/problems/all-paths-from-source-to-target/description/

class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        int n = graph.length;
        curr.add(0);
        helper(graph,0,n-1,res,curr);
        return res;
    }
    public void helper(int [][]graph, int src, int dest, List<List<Integer>> res, List<Integer> curr){
        if(src==dest){
            res.add(new ArrayList<>(curr));
            return;
        }
        for(int j:graph[src]){
            curr.add(j);
            helper(graph,j,dest,res,curr);
            curr.remove(curr.size()-1);
        }
    }
}