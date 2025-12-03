// https://leetcode.com/problems/battleships-in-a-board/description/

class Solution {
    public int countBattleships(char[][] board) {
        int ans = 0;
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                if(board[i][j]=='X'){
                    dfs(i,j,board);
                    ans++;
                }
            }
        }
        return ans;
    }
    public void dfs(int i, int j, char[][] board){
        board[i][j] = '.';
        int dx[] = {-1,0,1,0};
        int dy[] = {0,-1,0,1};
        for(int k=0;k<4;k++){
            int nr = i + dx[k];
            int nc = j + dy[k];
            if(isValid(nr,nc,board)) dfs(nr,nc,board);
        }
    }
    public boolean isValid(int i, int j, char[][] board){
        if(i>=0 && i<board.length && j>=0 && j<board[0].length && board[i][j]=='X') return true;
        return false;
    }
}