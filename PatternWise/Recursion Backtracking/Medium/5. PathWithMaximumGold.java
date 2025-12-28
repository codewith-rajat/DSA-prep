// https://leetcode.com/problems/path-with-maximum-gold/description/

class Solution {
    public int getMaximumGold(int[][] grid) {
        int ans = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                ans = Math.max(ans,help(grid,i,j));
            }
        }
        return ans;
    }
    public int help(int [][]grid, int x, int y){
        if(x<0 || y<0 ||x>=grid.length || y>=grid[0].length || grid[x][y]==0) return 0;
        int gold = grid[x][y];
        grid[x][y] = 0;
        int maxgold = 0;
        maxgold = Math.max(maxgold,help(grid,x,y+1));
        maxgold = Math.max(maxgold,help(grid,x+1,y));
        maxgold = Math.max(maxgold,help(grid,x,y-1));
        maxgold = Math.max(maxgold,help(grid,x-1,y));
        grid[x][y] = gold;
        return gold + maxgold;
    }
}