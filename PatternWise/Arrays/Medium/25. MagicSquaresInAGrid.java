// https://leetcode.com/problems/magic-squares-in-grid/description/

class Solution {
    public boolean helper(int[][] grid, int r, int c){
        int sum = grid[r][c] + grid[r][c+1] + grid[r][c+2];
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(grid[r+i][c+j]<1 || grid[r+i][c+j]>9 || set.contains(grid[r+i][c+j])) 
                    return false;
                    set.add(grid[r+i][c+j]);
            }
        }
        for(int i=0;i<3;i++){
            if((grid[r][c+i] + grid[r+1][c+i] + grid[r+2][c+i])!=sum) return false;
            if((grid[r+i][c] + grid[r+i][c+1] + grid[r+i][c+2])!=sum) return false; 
        }
        if((grid[r][c] + grid[r+1][c+1] + grid[r+2][c+2])!=sum) return false;
        if((grid[r][c+2] + grid[r+1][c+1] + grid[r+2][c])!=sum) return false;
        return true;
    }
    public int numMagicSquaresInside(int[][] grid) {
        int n = grid.length, m = grid[0].length,c=0;
        if(n<3 || m<3) return 0;
        for(int i=0;i<=n-3;i++){
            for(int j=0;j<=m-3;j++){
                if(helper(grid,i,j)) c++;
            }
        }
        return c;
    }
}