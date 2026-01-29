// https://leetcode.com/problems/find-the-winner-of-the-circular-game/description/
// leetcode 1823  

class Solution {
    public int findTheWinner(int n, int k) {
        Queue<Integer> pq = new LinkedList<>();
        for(int i=1;i<=n;i++) pq.add(i);
        while(pq.size()>1){
            for(int i=1;i<k;i++) pq.add(pq.poll());
            pq.poll();
        }
        return pq.poll();
    }
}