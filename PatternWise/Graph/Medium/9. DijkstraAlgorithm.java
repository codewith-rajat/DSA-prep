// https://www.geeksforgeeks.org/problems/implementing-dijkstra-set-1-adjacency-matrix/1

class Pair{
    int nbr;
    int weight;
    Pair(int n,int w){
        nbr = n;
        weight = w;
    }
}

class Solution {
    public int[] dijkstra(int V, int[][] edges, int src) {
        // code here
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];
            adj.get(u).add(new Pair(v,w));
            adj.get(v).add(new Pair(u,w));
        }
        PriorityQueue<Pair> q = new PriorityQueue<>((a,b)->a.weight-b.weight);
        int dist[] = new int[V];
        Arrays.fill(dist,(int)1e9);
        dist[src] = 0;
        q.add(new Pair(src,0));
        while(q.size()>0){
            Pair u = q.poll();
            for(Pair p: adj.get(u.nbr)){
                if(dist[u.nbr]+p.weight<dist[p.nbr]){
                    dist[p.nbr]=dist[u.nbr]+p.weight;
                    q.add(new Pair(p.nbr,dist[p.nbr]));
                }
            }
        }
        
        return dist;
    }
}