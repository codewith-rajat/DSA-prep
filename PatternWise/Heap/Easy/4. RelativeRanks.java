// https://leetcode.com/problems/relative-ranks/description/

class Solution {
    public String[] findRelativeRanks(int[] score) {
        String[] res = new String[score.length];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->b[0]-a[0]);
        for(int i=0;i<score.length;i++) pq.add(new int[]{score[i],i});
        int j=1;
        while(!pq.isEmpty()){
            if(j<=3){
                int curr[] = pq.poll();
                if(j==1) res[curr[1]]= "Gold Medal";
                else if(j==2) res[curr[1]] = "Silver Medal";
                else res[curr[1]] = "Bronze Medal";
            }
            else{
                int temp[] = pq.poll();
                res[temp[1]] = j+"";
            }
            j++;
        }
        return res;
    }
}