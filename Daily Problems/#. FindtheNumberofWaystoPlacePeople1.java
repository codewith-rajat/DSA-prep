// https://leetcode.com/problems/find-the-number-of-ways-to-place-people-i/description/

class Solution {
    public int numberOfPairs(int[][] points) {
        Arrays.sort(points,(a,b)->{
            if(a[0]==b[0]) return Integer.compare(b[1],a[1]);
            return Integer.compare(a[0],b[0]);
        });
        int c= 0;
        int n = points.length;
        for(int i=0;i<n;i++){
            int top = points[i][1];
            int bottom = Integer.MIN_VALUE;
            for(int j = i+1;j<n;j++){
                int y = points[j][1];
                if(bottom<y && y<=top){
                    c++;
                    bottom=y;
                    if(bottom==top) break;
                }
            }
        }
        return c;
    }
}