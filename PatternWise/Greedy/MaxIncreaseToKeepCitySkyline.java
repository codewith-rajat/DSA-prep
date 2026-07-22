// https://leetcode.com/problems/max-increase-to-keep-city-skyline/description/?envType=problem-list-v2&envId=greedy

class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int n = grid.length;
        int rc[][] = new int[2][n];
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                rc[0][i] = Math.max(rc[0][i],grid[i][j]);
                rc[1][i] = Math.max(rc[1][i],grid[j][i]);
            }
        }
        int sum = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                sum += Math.min(rc[0][i],rc[1][j])-grid[i][j];
            }
        }
        return sum;
    }
}