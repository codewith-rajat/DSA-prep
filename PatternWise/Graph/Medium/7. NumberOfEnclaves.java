// https://leetcode.com/problems/number-of-enclaves/description/

class Solution {
    public int numEnclaves(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        boolean visited[][] = new boolean[m][n];
        for(int j=0;j<n;j++){
            if(!visited[0][j] && mat[0][j]==1){
                dfs(0,j,visited,mat);
            }
            if(!visited[m-1][j] && mat[m-1][j]==1){
                dfs(m-1,j,visited,mat);
            }
        }
        for(int i=0;i<m;i++){
            if(!visited[i][0] && mat[i][0]==1){
                dfs(i,0,visited,mat);
            }
            if(!visited[i][n-1] && mat[i][n-1]==1){
                dfs(i,n-1,visited,mat);
            }
        }
        int ans = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!visited[i][j] && mat[i][j] == 1) ans++;
            }
        }
        return ans;
    }
    public static void dfs(int i, int j, boolean[][] visited, int[][] mat){
        visited[i][j] = true;
        int dx[] = {0,1,0,-1};
        int dc[] = {-1,0,1,0};
        for(int k=0;k<4;k++){
            int nr = i + dx[k];
            int nc = j + dc[k];
            if(isValid(nr,nc,mat.length,mat[0].length,visited,mat)){
                dfs(nr,nc,visited,mat);
            }
        }
    }
    public static boolean isValid(int nr, int nc, int m, int n  , boolean [][] visited, int [][] mat){
        if(nr>=0 && nr<m && nc>=0 && nc<n && !visited[nr][nc] && mat[nr][nc] == 1){
            return true;
        }
        return false;
    }
}