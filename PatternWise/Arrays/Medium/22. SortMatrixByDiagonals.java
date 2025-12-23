// https://leetcode.com/problems/sort-matrix-by-diagonals/

class Solution {
    public int[][] sortMatrix(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        Map<Integer,List<Integer>> mp = new HashMap<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                mp.putIfAbsent(i-j,new ArrayList<>());
                mp.get(i-j).add(grid[i][j]);
            }
        }
        for(int key : mp.keySet()){
            if(key<0){
                List<Integer> ls = mp.get(key);
                Collections.sort(ls);
                mp.put(key,ls);
            }else{
                List<Integer> ls = mp.get(key);
                Collections.sort(ls,Collections.reverseOrder());
                mp.put(key,ls);
            }
        }
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    int key = i-j;
                    grid[i][j] = mp.get(i-j).get(0);
                    mp.get(i-j).remove(0);
                }
            }
        return grid;
    }
}