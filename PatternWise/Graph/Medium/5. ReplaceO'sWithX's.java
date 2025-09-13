// https://leetcode.com/problems/surrounded-regions/description/

class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        boolean visited[][] = new boolean[m][n]; 
        for(int i=0;i<m;i++){
            if(!visited[i][0] && board[i][0]=='O'){
                dfs(i,0,board,visited);
            }
            if(!visited[i][n-1] && board[i][n-1]=='O'){
                dfs(i,n-1,board,visited);
            }
        }
        for(int j=0;j<n;j++){
            if(!visited[0][j] && board[0][j]=='O'){
                dfs(0,j,board,visited);
            }
            if(!visited[m-1][j] && board[m-1][j]=='O'){
                dfs(m-1,j,board,visited);
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!visited[i][j] && board[i][j]=='O'){
                    board[i][j]='X';
                }
            }
        }
    }
    public void dfs(int i,int j,char[][] board, boolean[][] visited){
        visited[i][j] = true;
        int dx[] = {0,1,0,-1};
        int dc[] = {1,0,-1,0};
        for(int k=0;k<4;k++){
            int nr = i + dx[k];
            int nc = j + dc[k];
            if(isValid(nr,nc,board,visited)){
                dfs(nr,nc,board,visited);
            }
        }
    }
    public boolean isValid(int nr, int nc, char[][] board, boolean [][] visited){
        int m = board.length;
        int n = board[0].length;
        if(nr>=0 && nr<m && nc>=0 && nc<n && board[nr][nc]=='O' && !visited[nr][nc]){
            return true;
        }
        return false;
    }
}