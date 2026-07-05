// https://leetcode.com/problems/keys-and-rooms/description/?envType=problem-list-v2&envId=graph
// lc 841

class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean visited[] = new boolean[rooms.size()];
        dfs(rooms,visited,0);
        for(boolean i : visited) if(i==false) return false;
        return true;
    }
    public void dfs(List<List<Integer>> rooms, boolean []visited, int node){
        visited[node] = true;
        for(int nei : rooms.get(node)){
            if(!visited[nei]){
                dfs(rooms,visited,nei);
            }
        }
    }
}