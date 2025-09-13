// https://www.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1

class Solution {
    public boolean isCycle(int V, int[][] edges) {
        // Code here
        boolean [] visited = new boolean[V];
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<V;i++) adj.add(new ArrayList<>());
        for(int[] e:edges){
            int u = e[0];
            int v = e[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        for(int i=0;i<V;i++){
            if(!visited[i]){
                if(dfs(i,-1,adj,visited)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean dfs(int node, int parent, List<List<Integer>> adj, 
                        boolean[] visited){
        visited[node] = true;
        for(int nbr : adj.get(node)){
            if(!visited[nbr]){
                if(dfs(nbr,node,adj,visited)){
                    return true;
                }
            }
            else if(nbr != parent){
                return true;
            }
        }
        return false;
    } 
}


// https://leetcode.com/problems/number-of-islands/

class Solution {
    public boolean isValid(int nr, int nc, int row, int col, boolean[][] visited, char[][] grid) {
        if(nr>=0 && nc>=0 && nr<row && nc<col && visited[nr][nc]==false && grid[nr][nc]=='1'){
            return true;
        }
        return false;
    }
    public int numIslands(char[][] grid) {
        // Code here
        int m = grid.length;
        int n = grid[0].length;
        int ans = 0;
        boolean [][] visited = new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!visited[i][j] && grid[i][j]=='1'){
                    bfs_matrix(grid,i,j,m,n,visited);
                    ans++;
                }
            }
        }
        return ans;
    }
    public void bfs_matrix(char[][] grid,int sr, int sc, int rows, int cols, boolean[][] visited){
        visited[sr][sc] = true;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sr,sc});
        while(q.size()>0){
            int curr[] = q.poll();
            int curr_row = curr[0];
            int curr_col = curr[1];
            int dr[] = {0,1,0,-1};
            int dc[] = {1,0,-1,0};
            for(int i=0;i<4;i++){
                int nbr_row = curr_row + dr[i];
                int nbr_col = curr_col + dc[i];
                if(isValid(nbr_row,nbr_col,rows,cols,visited,grid)){
                    visited[nbr_row][nbr_col] = true;
                    q.add(new int[]{nbr_row,nbr_col});
                }
            }
        }
    }
}