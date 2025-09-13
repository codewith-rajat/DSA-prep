// https://www.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1

class Solution {
    public boolean isCyclic(int V, int[][] edges) {
        // code here
        boolean [] visited = new boolean[V];
        boolean [] parent = new boolean[V];
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<V;i++) adj.add(new ArrayList<>());
        for(int[] e : edges){
            int u = e[0];
            int v = e[1];
            adj.get(u).add(v);
        }
        for(int i=0;i<V;i++){
            if(!visited[i]){
                if(dfs(i,adj,visited,parent))return true;
            }
        }
        return false;
    }
    public boolean dfs(int node, List<List<Integer>> adj, boolean [] visited, boolean[] parent){
        visited[node] = true;
        parent[node] = true;
        for(int nbr : adj.get(node)){
            if(!visited[nbr]){
                if(dfs(nbr,adj,visited,parent)) return true;
            }
            else if(parent[nbr]) return true;
        }
        parent[node] = false;
        return false;
    }
}