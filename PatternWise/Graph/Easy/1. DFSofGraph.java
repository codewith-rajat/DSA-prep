// https://www.geeksforgeeks.org/problems/depth-first-traversal-for-a-graph/1  2-sep-2025

class Solution {
    public void helper(ArrayList<ArrayList<Integer>> adj,
    ArrayList<Integer> ans,boolean visited[],int node){
        visited[node]=true;
        ans.add(node);
        for(int i:adj.get(node)){
            if(!visited[i]){
                helper(adj,ans,visited,i);
            }
        }
    }
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean visited[] = new boolean[adj.size()];
        ArrayList<Integer> ans = new ArrayList<>();
        helper(adj,ans,visited,0);
        return ans;
    }
}



class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    public void helper(ArrayList<ArrayList<Integer>> adj,
    ArrayList<Integer> ans,boolean visited[],int node){
        visited[node]=true;
        ans.add(node);
        for(int i:adj.get(node)){
            if(!visited[i]){
                helper(adj,ans,visited,i);
            }
        }
    }
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean visited[] = new boolean[adj.size()];
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0;i<adj.size();i++){
            if(!visited[i]){
                helper(adj,ans,visited,i);
            }
        }
        return ans;
    }
}