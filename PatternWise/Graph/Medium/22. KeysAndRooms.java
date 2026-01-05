// https://leetcode.com/problems/keys-and-rooms/?envType=problem-list-v2&envId=graph
class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean visited[] = new boolean [rooms.size()];
        visited[0] = true;
        dfs(0,visited,rooms);
        for(boolean v : visited){
            if(!v) return false;
        }
        return true;
    }
    public void dfs(int node,boolean []visited,List<List<Integer>> rooms){
        visited[node] = true;
        for(int nei : rooms.get(node)){
            if(!visited[nei]) dfs(nei,visited,rooms);
        }
    }
}