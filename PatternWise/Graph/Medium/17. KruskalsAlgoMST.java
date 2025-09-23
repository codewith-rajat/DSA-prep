// https://www.geeksforgeeks.org/problems/minimum-spanning-tree/1

class Solution {
    public int spanningTree(int V, int[][] edges) {
        // code here
        UnionFind uf = new UnionFind(V);
        Arrays.sort(edges,Comparator.comparingInt(e->e[2]));
        int cost = 0,count = 0;
        for(int[]e:edges){
            int x = e[0],y=e[1],w=e[2];
            if(uf.find(x)!=uf.find(y)){
                uf.union(x,y);
                cost += w;
                if(++count == V-1) break;
            }
        }
        return cost;
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