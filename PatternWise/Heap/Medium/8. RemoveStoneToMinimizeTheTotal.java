// https://leetcode.com/problems/remove-stones-to-minimize-the-total/description/

class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        for(int i:piles) pq.add(i);
        while(k-->0){
            int p = pq.poll();
            p = p-(p/2);
            pq.add(p);
        }
        int ans = 0;
        while(!pq.isEmpty()) ans += pq.poll();
        return ans;
    }
}