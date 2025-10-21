// https://leetcode.com/problems/corporate-flight-bookings/description/

class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        //converted to 0-based indexing
        int ans[] = new int[n+1]; 
        for(int i=0;i<bookings.length;i++){
            int l = bookings[i][0]-1, r = bookings[i][1]-1, add = bookings[i][2];
            ans[l] = ans[l] + add;
            ans[r+1] = ans[r+1] - add;
        }
        int res[] = new int[n];
        res[0] = ans[0];
        for(int i = 1;i<n;i++){
            res[i] = res[i-1] + ans[i];
        }
        return res;
    }
}



class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int ans[] = new int[n+2];
        for(int i=0;i<bookings.length;i++){
            int l = bookings[i][0], r = bookings[i][1], add = bookings[i][2];
            ans[l] = ans[l] + add;
            ans[r+1] = ans[r+1] - add;
        }
        int res[] = new int[n];
        res[0] = ans[1];
        for(int i = 1;i<n;i++){
            res[i] = res[i-1] + ans[i+1];
        }
        return res;
    }
}