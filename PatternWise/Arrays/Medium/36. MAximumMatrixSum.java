// https://leetcode.com/problems/maximum-matrix-sum/
// lc 1975

class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int min = Integer.MAX_VALUE, c = 0;
        long sum = 0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]<0) c++;
                min = Math.min(min,Math.abs(matrix[i][j]));
                sum += Math.abs(matrix[i][j]);
            }
        }
        if(c%2==0) return sum;
        return sum - 2L * min;
    }
}