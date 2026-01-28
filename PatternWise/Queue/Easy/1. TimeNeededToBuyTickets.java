// https://leetcode.com/problems/time-needed-to-buy-tickets/description/
// leetcode 2073
class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        Queue<Integer> pq = new LinkedList<>();
        for(int i=0;i<tickets.length;i++) pq.add(i);
        int ans = 0;
        while(tickets[k]>0){
            int idx = pq.remove();
            tickets[idx]--;
            ans++;
            if(tickets[idx]!=0) pq.add(idx);
        }
        return ans;
    }
}