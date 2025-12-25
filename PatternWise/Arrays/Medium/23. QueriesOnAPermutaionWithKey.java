// https://leetcode.com/problems/queries-on-a-permutation-with-key/description/

class Solution {
    public int[] processQueries(int[] queries, int m) {
        int[] p = new int[m];
        for(int i=1;i<=m;i++){
            p[i-1]=i;
        }
        int n = queries.length;
        int[] res = new int[n];
        for(int i=0;i<n;i++){
            int ind=-1;
            for(int j=0;j<m;j++){
                if(queries[i]==p[j]){
                    ind=j;
                    break;
                }
            }
            res[i] = ind;
            for(int j=ind;j>0;j--){
                int temp = p[j];
                p[j] = p[j-1];
                p[j-1] = temp; 
            }
        }
        return res;
    }
}

class Solution {
    public int[] processQueries(int[] queries, int m) {
        List<Integer> ls = new ArrayList<>();
        int ans [] = new int[queries.length];
        for(int i=1;i<=m;i++) ls.add(i);
        for(int i=0;i<queries.length;i++){
            int pos = ls.indexOf(queries[i]);
            ans[i] = pos;
            ls.remove(pos);
            ls.add(0,queries[i]);
        }
        return ans;
    }
}