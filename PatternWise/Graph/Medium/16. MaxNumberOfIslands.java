// https://leetcode.com/problems/max-area-of-island

class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int ans = 0;
        boolean [][] visited = new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1 && !visited[i][j]){
                    int temp = dfs(grid,i,j,m,n,visited,0);
                    ans = Math.max(ans,temp);
                }
            }
        }
        return ans;
    }
    public int dfs(int[][] grid, int i,int j, int m, int n, boolean[][] visited,int ans){
        visited[i][j] = true;
        ans++;
        int dx[] = {0,1,0,-1};
        int dc[] = {1,0,-1,0};
        for(int k=0;k<4;k++){
            int nr = i + dx[k];
            int nc = j + dc[k];
            if(isValid(nr,nc,m,n,grid,visited)){
                dfs(grid,nr,nc,m,n,visited,ans);
            }
        }
        return ans;
    }
    public boolean isValid(int nr, int nc, int m, int n, int [][]grid, boolean[][] visited){
        if(nr>=0 && nr<m && nc>=0 && nc<n && grid[nr][nc]==1 && !visited[nr][nc]) return true;
        return false;
    }
}


import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            double n = sc.nextDouble();
            double k = sc.nextDouble();
            double x = sc.nextDouble();
            ArrayList<Integer> ls = new ArrayList<>();
            for(int i=0;i<n;i++){
                int temp = sc.nextInt();
                ls.add(temp);
            }
            for(int i=0;i<k;i++){
                Collections.sort(ls);
                int last = ls.get(ls.size()-1);
                ls.remove(ls.size()-1);
                ls.add(last/2);
                ls.add(last/2);
            }
            Collections.sort(ls);
        }
        for(int i=ls.size()-1;i>=0;i--){
            if(i==(ls.size()-x)){
                int ans = ls.get(i);
                System.out.println(ans);
                break;
            }
        }
    }
}