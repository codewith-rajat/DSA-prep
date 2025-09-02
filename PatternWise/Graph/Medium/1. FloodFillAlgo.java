// https://www.geeksforgeeks.org/problems/flood-fill-algorithm1856/1

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        // Code here
        int m = image.length;
        int n = image[0].length;
        int color = image[sr][sc];
        boolean [][] visited = new boolean[m][n];
        traverse(image,sr,sc,m,n,visited,newColor,color);
        return image;
    }
    public void traverse(int [][] image, int sr, int sc,
    int rows,int cols, boolean[][] visited, int newColor,int color){
        if(sc<0 || sr<0 || sc>=cols || sr>=rows || (visited[sr][sc]==true) || (image[sr][sc]!=color)){
            return;
        }
        visited[sr][sc]=true;
        image[sr][sc] = newColor;
        traverse(image,sr,sc+1,rows,cols,visited,newColor,color);
        traverse(image,sr+1,sc,rows,cols,visited,newColor,color);
        traverse(image,sr,sc-1,rows,cols,visited,newColor,color);
        traverse(image,sr-1,sc,rows,cols,visited,newColor,color);
    }
}