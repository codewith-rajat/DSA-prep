// https://leetcode.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/description/

class Solution { //Dijkstra
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] e : edges) {
            adj.get(e[0]).add(new int[]{e[1], e[2]});
            adj.get(e[1]).add(new int[]{e[0], e[2]});
        }
        int ansCity = -1;
        int minCount = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int count = dijkstra(i, n, adj, distanceThreshold);
            if (count <= minCount) {
                minCount = count;
                ansCity = i;
            }
        }
        return ansCity;
    }
    private int dijkstra(int src, int n, List<List<int[]>> adj, int threshold) {
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        PriorityQueue<int[]> pq =
                new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{src, 0});
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int node = curr[0];
            int d = curr[1];
            if (d > dist[node]) continue;
            for (int[] nei : adj.get(node)) {
                int next = nei[0];
                int weight = nei[1];
                if (dist[node] + weight < dist[next]) {
                    dist[next] = dist[node] + weight;
                    pq.offer(new int[]{next, dist[next]});
                }
            }
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (i != src && dist[i] <= threshold) {
                count++;
            }
        }
        return count;
    }
}


class Solution { //DFS
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int[] e : edges) {
            adj.get(e[0]).add(new int[]{e[1], e[2]});
            adj.get(e[1]).add(new int[]{e[0], e[2]});
        }
        int mincity = -1;
        int mincount = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            int dist[] = new int[n];
            Arrays.fill(dist,Integer.MAX_VALUE);
            dfs(i,0,distanceThreshold,adj,dist);
            int count = 0;
            for(int j=0;j<dist.length;j++){
                if(i!=j && dist[j]<=distanceThreshold) count++; 
            }
            if(count<=mincount){
                mincount = count;
                mincity = i;
            }
        }
        return mincity;
    }
    public void dfs(int node, int currdist, int threshold,List<List<int[]>> adj,int[] dist){
        if(currdist>threshold || currdist>=dist[node]) return;
        dist[node] = currdist;
        for(int[] nei : adj.get(node)){
            dfs(nei[0],currdist + nei[1],threshold,adj,dist);
        }
    }
}