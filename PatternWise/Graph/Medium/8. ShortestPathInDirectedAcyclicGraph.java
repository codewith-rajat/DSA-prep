// https://www.geeksforgeeks.org/problems/shortest-path-in-undirected-graph/1

// topological sort used


class Pair{
    int nbr;
    int weight;
    Pair(int n, int w){
        nbr = n;
        weight = w;
    }
}


class Solution {

    public int[] shortestPath(int V, int E, int[][] edges) {
        // Code here
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];
            adj.get(u).add(new Pair(v,w));
        }
        boolean [] visited = new boolean[V];
        Stack<Integer> s = new Stack<>();
        for(int i=0;i<V;i++){
            if(!visited[i]){
                topoSort(i,adj,visited,s);
            }
        }
        int dist[] = new int[V];
        Arrays.fill(dist,(int)1e9);
        dist[0] = 0;
        while(s.size()>0){
            int u = s.pop();
            for(Pair p : adj.get(u)){
                int v = p.nbr;
                int w = p.weight;
                if(dist[u] + w<dist[v]){
                    dist[v] = dist[u] + w;
                }
            }
        }
        for(int i=0;i<V;i++){
            if(dist[i]==1e9) dist[i] = -1;
        }
        return dist;
    }
    public static void 
    topoSort(int node, ArrayList<ArrayList<Pair>> adj, 
        boolean[] visited, Stack<Integer> s){
            visited[node] = true;
            for(Pair p : adj.get(node)){
                if(!visited[p.nbr]){
                    topoSort(p.nbr,adj,visited,s);
                }
            }
            s.push(node);
        }
}