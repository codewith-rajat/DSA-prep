// https://leetcode.com/problems/minimum-cost-path-with-edge-reversals/description/?envType=daily-question&envId=2026-01-27
// leetcode3650
class Solution {
    public int minCost(int n, int[][] edges) {
        List<List<int[]>> ls = new ArrayList<>();
        for(int i=0;i<n;i++) ls.add(new ArrayList<>());
        for(int []e : edges){
            ls.get(e[0]).add(new int[]{e[1],e[2]});
            ls.get(e[1]).add(new int[]{e[0],2*e[2]});
        }
        int dist[] =  new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        dist[0] = 0;
        pq.add(new int[]{0,0});
        while(!pq.isEmpty()){
            int curr[] = pq.poll();
            int currdist = curr[0];
            int node = curr[1];
            if(currdist>dist[node]) continue;
            for(int[] nei : ls.get(node)){
                int next = nei[0];
                int cost = nei[1];
                if(dist[node] + cost < dist[next]){
                    dist[next] = dist[node] + cost;
                    pq.add(new int[]{dist[next],next});
                }
            }
        }
        return dist[n-1] == Integer.MAX_VALUE ? -1 : dist[n-1];
    }
}