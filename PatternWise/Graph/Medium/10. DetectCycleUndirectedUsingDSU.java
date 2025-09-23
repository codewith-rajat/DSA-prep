// https://www.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1

class UnionFind {
    int parent[];
    int rank[];
    UnionFind(int V){
        parent =new int[V+1];
        rank=new int[V+1];
        for(int i=0;i<=V;i++){
            parent[i]=i;        }
    }
    int find(int node){
    if(parent[node]==node)
    return node;
    return find(parent[node]);
}
    boolean union(int u,int v){
        int pu=find(u);
        int pv=find(v);
        if(pu==pv) return false;
        if(rank[pu]>rank[pv]){
            parent[pv]=pu;
        }
        else if(rank[pv]>rank[pu]){
            parent[pu]=pv;
        }
        else{ 
            parent[pv]=pu;
            rank[pu]++;
        }
        return true;
    }
    
}
class Solution {
    public boolean isCycle(int V, int[][] edges) {
        // Code here
        UnionFind uf = new UnionFind(V);
        for(int edge[]:edges){
            int u = edge[0];
            int v = edge[1];
        
            if(uf.union(u,v)==false){
                return true;
            }
        }
        return false;
        
    }
}