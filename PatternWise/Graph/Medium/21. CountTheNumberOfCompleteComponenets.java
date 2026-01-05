// https://leetcode.com/problems/count-the-number-of-complete-components/description/?envType=problem-list-v2&envId=graph

class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        int ans = 0;
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int []e : edges){
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        boolean visited[] = new boolean[n];
        for(int i=0;i<n;i++){
            if(!visited[i]){
                int count[] = new int[2];
                dfs(i,adj,visited,count);
                int nodes = count[0];
                int edgecount = count[1]/2;
                if(edgecount==(nodes*(nodes-1)/2)) ans++;
            }
        }
        return ans;
    }
    public void dfs(int node, List<List<Integer>> adj, boolean[] visited, int[] count){
        visited[node] = true;
        count[0]++;
        count[1] += adj.get(node).size();
        for(int nei : adj.get(node)){
            if(!visited[nei]) dfs(nei,adj,visited,count);
        }
    }
}