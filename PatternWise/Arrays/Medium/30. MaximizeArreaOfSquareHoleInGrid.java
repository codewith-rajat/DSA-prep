// https://leetcode.com/problems/maximize-area-of-square-hole-in-grid/description/?envType=daily-question&envId=2026-01-15
// leetcode2943
class Solution {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        Arrays.sort(hBars);
        Arrays.sort(vBars);
        int maxHCons = 1, maxVCons = 1, hCons = 1, vCons = 1;
        for(int i=1;i<hBars.length;i++){
            if(hBars[i]-hBars[i-1]==1) hCons++;
            else hCons = 1;
            maxHCons = Math.max(maxHCons,hCons);
        }
        for(int i=1;i<vBars.length;i++){
            if(vBars[i]-vBars[i-1]==1) vCons++;
            else vCons = 1;
            maxVCons = Math.max(maxVCons,vCons);
        }
        int side = Math.min(maxHCons,maxVCons) + 1;
        return side * side;                    
    }
}