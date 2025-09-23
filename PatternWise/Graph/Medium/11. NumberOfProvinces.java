// https://leetcode.com/problems/number-of-provinces/   

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
    public int findCircleNum(int[][] isConnected) {
        UnionFind uf = new UnionFind(isConnected.length);
        for(int i=0;i<isConnected.length;i++){
            for(int j=0;j<isConnected.length;j++){
                if(isConnected[i][j]==1){
                    uf.union(i,j);
                }
            }
        }
        int ans=0;
        for(int i=0;i<isConnected.length;i++){
            if(uf.find(i)==i) ans++;
        }
        return ans;
    }
}