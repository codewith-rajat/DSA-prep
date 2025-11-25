// https://leetcode.com/problems/increment-submatrices-by-one/description/?envType=daily-question&envId=2025-11-14

class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int [][] ans = new int[n][n];
        for(int []q : queries){
            int row1 = q[0], col1 = q[1], row2 = q[2], col2 = q[3];
            for(int j=row1;j<=row2;j++){
                ans[j][col1] += 1;
                if(col2+1<n) ans[j][col2+1] -= 1;
            }
        }
        for(int i=0;i<n;i++){
            for(int j=1;j<n;j++){
                ans[i][j] += ans[i][j-1]; 
            }
        }
        return ans;
    }
}