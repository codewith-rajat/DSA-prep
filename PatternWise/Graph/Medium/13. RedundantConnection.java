// https://leetcode.com/problems/redundant-connection/


class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        UnionFind uf = new UnionFind(edges.length);
        for(int[] edge:edges){
            if(!uf.union(edge[0],edge[1])){
                return edge;
            }
        }
        return new int[]{-1,-1};
    }
}
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
    if(parent[node]==node) return node;
    return parent[node] = find(parent[node]);
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