// https://leetcode.com/problems/game-of-life

class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        int dx[] = {0,1,0,-1,-1,-1,1,1};
        int dc[] = {1,0,-1,0,1,-1,1,-1};
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                    int live = 0;
                    for(int k=0;k<8;k++){
                        int nr = i + dx[k];
                        int nc = j + dc[k];
                        if(nr>=0 && nr<m && nc>=0 && nc<n && Math.abs(board[nr][nc])==1) 
                            live++;
                    }
                    if(board[i][j]==1 && (live<2 || live>3)) board[i][j]=-1;  
                    if(board[i][j]==0 && live==3) board[i][j]=2;
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]>0) board[i][j]=1;
                else board[i][j] = 0;
            }
        }
    }
}

//with extra space
class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        int [][] copy = new int[m][n];
        int dx[] = {0,1,0,-1,-1,-1,1,1};
        int dc[] = {1,0,-1,0,1,-1,1,-1};
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                    int live = 0;
                    for(int k=0;k<8;k++){
                        int nr = i + dx[k];
                        int nc = j + dc[k];
                        if(nr>=0 && nr<m && nc>=0 && nc<n && board[nr][nc]==1) live++;
                    }
                    if(board[i][j]==1){
                        if(live<2 || live>3) copy[i][j]=0;
                        else copy[i][j]=1; 
                    }else{
                        if(live==3) copy[i][j]=1;
                        else copy[i][j]=0;
                    }
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                board[i][j] = copy[i][j];
            }
        }
    }
}