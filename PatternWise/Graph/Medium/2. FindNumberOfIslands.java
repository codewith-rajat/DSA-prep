// https://www.geeksforgeeks.org/problems/find-the-number-of-islands/1

class Solution {
    public static boolean isValid(int nr, int nc, int rows, int cols, boolean visited[][],char [][] mat){
        if(nr>=0 && nr<rows && nc>=0 && nc<cols && !visited[nr][nc] && mat[nr][nc]!='W'){
            return true;
        }
        return false;
    }
    public int countIslands(char[][] mat) {
        // Code here
        int m = mat.length;
        int n = mat[0].length;
        boolean [][] visited = new boolean[m][n];
        int ans = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!visited[i][j] && mat[i][j]!='W'){
                    bfs_matrix(mat,i,j,m,n,visited);
                    ans++;
                }
            }
        }
        return ans;
    }
    public static void bfs_matrix(char[][] mat,int sr, int sc, int rows,int cols,boolean visited[][]){
        Queue<int[]> q=new LinkedList<>();
        visited[sr][sc]=true;
        q.add(new int[] {sr,sc});
        while(q.size()>0){
            int[] curr = q.poll();
            int curr_row=curr[0];
            int curr_col=curr[1];
            int dr[]={0,1,0,-1,-1,-1,1,1};
            int dc[]={1,0,-1,0,-1,1,-1,1};
            for(int i=0;i<dr.length;i++){
                int nbr_row=curr_row+dr[i];
                int nbr_col=curr_col+dc[i];
                if(isValid(nbr_row,nbr_col,rows,cols,visited,mat)){
                    visited[nbr_row][nbr_col]=true;
                    q.add(new int[] {nbr_row,nbr_col});
                }
            }

        }

    }
}