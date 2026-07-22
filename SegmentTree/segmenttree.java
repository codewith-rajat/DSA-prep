public class segmenttree{
    public static void main(String[] args){
        int arr[] = {1,2,3,4};
        int tree[] = new int[arr.length*4];
        build(arr,tree,0,0,arr.length-1);
        for(int i=0;i<tree.length;i++) System.out.print(tree[i]+" ");
        System.out.println(query(tree,0,0,arr.length-1,0,3));
    }
    public static void build(int[] arr, int[] tree, int node, int l, int r){
        if(l==r) {
            tree[node] = arr[l];
            return;
        }
        int mid = l + (r-l)/2;
        build(arr,tree,2*node+1,l,mid);
        build(arr,tree,2*node+2,mid+1,r);
        tree[node] = tree[2*node+1] + tree[2*node+2]; 
    }
    public static int query(int [] tree, int node, int l, int r, int ql, int qr){
        if(ql<=l && qr>=r) return tree[node];
        if(qr<l || r<ql) return 0;
        int mid = l + (r-l)/2;
        int lefts = query(tree,2*node+1,l,mid,ql,qr);
        int rights = query(tree,2*node+2,mid+1,r,ql,qr);
        return lefts + rights;
    }
}