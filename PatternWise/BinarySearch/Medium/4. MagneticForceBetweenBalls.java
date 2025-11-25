// https://leetcode.com/problems/magnetic-force-between-two-balls/

class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int n = position.length;
        int minn = 1;
        int maxx = position[n-1]-position[0];
        int ans = 0;
        while(minn<=maxx){
            int mid = minn + (maxx-minn)/2;
            if(isPossible(mid,m,position)){
                ans = mid;
                minn = mid+1;
            }else maxx = mid-1;
        }
        return ans;
    }
    public boolean isPossible(int mid, int m, int[] position){
        int count = 1;
        int prev = position[0];
        for(int i=1;i<position.length;i++){
            int curr = position[i];
            if(curr-prev >= mid){
                prev = curr;
                count++;
            }
            if(count==m) break;
        }
        if(count==m) return true;
        return false;
    }
}