// https://leetcode.com/problems/koko-eating-bananas/

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxx = Arrays.stream(piles).max().getAsInt();
        int l=1,r=maxx;
        int ans = 0;
        while(l<=r){
            int mid = l + (r-l)/2;
            int sum=0;
            for(int i=0;i<piles.length;i++){
                sum += Math.ceil((double)piles[i]/mid);
            }
            if(sum<=h){
                ans = mid;
                r = mid-1;
            }else l = mid+1;
        }
        return ans;
    }
}