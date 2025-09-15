// https://leetcode.com/problems/01-matrix/description/

class Solution {
    public boolean isValid(int nr, int nc, int row, int col, boolean [][] visited, int[][] grid){
        if(nr>=0 && nr<row && nc>=0 && nc<col && !visited[nr][nc] && grid[nr][nc]==1){
            return true;
        }
        return false;
    }
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        boolean[][] visited = new boolean[m][n];
        int [][] dist = new int[m][n];
        Queue<int[]> q = new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==0){
                    q.add(new int[]{i,j,0});
                    visited[i][j]=true;
                    dist[i][j]=0;
                }
            }
        }
        while(q.size()>0){
            int curr[] = q.poll();
            int curr_row = curr[0];
            int curr_col = curr[1];
            int curr_dis = curr[2];
            int dx[] = {0,1,0,-1};
            int dc[] = {1,0,-1,0};
            for(int i=0;i<4;i++){
                int nr = curr_row + dx[i];
                int nc = curr_col + dc[i];
                int nd = curr_dis + 1;
                if(isValid(nr,nc,m,n,visited,mat)){
                    q.add(new int[]{nr,nc,nd});
                    visited[nr][nc] = true;
                    dist[nr][nc] = nd;
                }
            }
        }
        return dist;
    }
}


// https://www.geeksforgeeks.org/problems/distance-of-nearest-cell-having-1-1587115620/1

class Solution {
    // Function to find distance of nearest 1 in the grid for each cell.
    public boolean isValid(int nr, int nc, int row, int col, boolean [][] visited, int[][] grid){
        if(nr>=0 && nr<row && nc>=0 && nc<col && !visited[nr][nc] && grid[nr][nc]==0){
            return true;
        }
        return false;
    }
    public int[][] nearest(int[][] grid) {
        // Code here
        int m = grid.length;
        int n = grid[0].length;
        boolean [][] visited = new boolean[m][n];
        int [][] dist = new int[m][n];
        Queue<int[]> q = new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    q.add(new int[]{i,j,0});
                    visited[i][j] = true;
                    dist[i][j] = 0;
                }
            }
        }
        while(q.size()>0){
            int curr[] = q.poll();
            int curr_row = curr[0];
            int curr_col = curr[1];
            int curr_dist = curr[2];
            int dx[] = {0,1,0,-1};
            int dc[] = {1,0,-1,0};
            for(int i=0;i<4;i++){
                int nbr_row = curr_row + dx[i];
                int nbr_col = curr_col + dc[i];
                int new_dist = curr_dist + 1;
                if(isValid(nbr_row,nbr_col,m,n,visited,grid)){
                    q.add(new int[]{nbr_row,nbr_col,new_dist});
                    visited[nbr_row][nbr_col] = true;
                    dist[nbr_row][nbr_col] = new_dist;
                }
            }
        }
        return dist;
    }
}