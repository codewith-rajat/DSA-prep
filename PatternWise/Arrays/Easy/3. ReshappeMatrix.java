// https://leetcode.com/problems/reshape-the-matrix

class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int row = mat.length;
        int col = mat[0].length;
        if (row * col != r * c || (row == r && c == col))
            return mat;
        int[][] res = new int[r][c];
        int k = 0, l = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                res[k][l++] = mat[i][j];
                if (l == c) {
                    l = 0;
                    k++;
                }
            }
        }
        return res;
    }
}