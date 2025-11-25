// https://leetcode.com/problems/find-right-interval/description/

class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int start[][] = new int[intervals.length][2];
        for(int i=0;i<intervals.length;i++) {
            start[i][0] = intervals[i][0];
            start[i][1] = i;
        }
        Arrays.sort(start,(a,b)->a[0]-b[0]);
        int res[] = new int[intervals.length];
        for(int i=0;i<intervals.length;i++){
            int ans = -1,l=0,r=start.length-1;
            while(l<=r){
                int mid = l + (r-l)/2;
                if(start[mid][0]>=intervals[i][1]){
                    ans = start[mid][1];
                    r = mid - 1;
                }else l = mid + 1;
            }
            res[i] = ans;
        }
        return res;
    }
}