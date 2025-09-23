// https://leetcode.com/problems/word-search/

class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        boolean visited[][] = new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(dfs(board,word,visited,i,j,0)) return true;
            }
        }
        return false;
    }
    public boolean dfs(char[][] board, String word, boolean[][] visited, int i,int j,int idx){
        if(idx==word.length()) return true;
        if(!isValid(board,word,visited,i,j,idx)) return false;
        visited[i][j] = true;
        int dx[] = {0,1,0,-1};
        int dc[] = {1,0,-1,0};
        for(int k=0;k<4;k++){
            int nr = i + dx[k];
            int nc = j + dc[k];
            if(dfs(board,word,visited,nr,nc,idx+1)) return true;
        }
        visited[i][j]=false;
        return false;
    }
    public boolean isValid(char[][]board,String word, boolean[][] visited,int nr, int nc, int idx){
        if(nr>=0 && nr<board.length && nc>=0 && nc<board[0].length && !visited[nr][nc] && word.charAt(idx)==board[nr][nc]) return true;
        return false;
    }
}