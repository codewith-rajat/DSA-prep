// https://leetcode.com/problems/rotate-the-box/description/

class Solution {
    public char[][] rotateTheBox(char[][] boxGrid) {
        for (int i = 0; i < boxGrid.length; i++) {
            int empty = boxGrid[0].length-1;
            for (int j = boxGrid[0].length - 1; j >= 0; j--) {
                if (boxGrid[i][j] == '*') {
                    empty = j-1;
                }else if(boxGrid[i][j]=='#') {
                    boxGrid[i][j] = '.';
                    boxGrid[i][empty] = '#';
                    empty--;
                }

            }
        }
        char ans[][] = new char[boxGrid[0].length][boxGrid.length];
        for(int i=0;i<boxGrid.length;i++){
            for(int j=0;j<boxGrid[0].length;j++){
                ans[j][boxGrid.length-1-i] = boxGrid[i][j];
            }
        }
        return ans;
    }
}