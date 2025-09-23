// https://leetcode.com/problems/number-of-operations-to-make-network-connected/

class UnionFind {
    int parent[];
    int rank[];
    UnionFind(int V){
        parent =new int[V];
        rank=new int[V];
        for(int i=0;i<V;i++){
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

class Solution {
    public int makeConnected(int n, int[][] connections) {
        int cables = connections.length;
        int pc = n;
        if(cables<pc-1) return -1;
        UnionFind uf = new UnionFind(n);
        for(int i=0;i<cables;i++){
                uf.union(connections[i][0],connections[i][1]);
        }
        int ans = 0;
        for(int i=0;i<pc;i++){
            if(uf.find(i)==i) ans++;
        } 
        return ans-1;
    }
}