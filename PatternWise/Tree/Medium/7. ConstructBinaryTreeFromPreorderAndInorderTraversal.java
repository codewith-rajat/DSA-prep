// https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/

class Solution { //optimised solution
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> mp = new HashMap<>();
        for(int i=0;i<inorder.length;i++) mp.put(inorder[i],i);
        return solve(preorder,mp,0,inorder.length-1,0);
    }
    public TreeNode solve(int [] preorder, Map<Integer,Integer> mp, int start, int end, 
                            int idx){
        if(start>end) return null;
        int rootval = preorder[idx];
        int i = mp.get(rootval);
        TreeNode root = new TreeNode(rootval);
        root.left = solve(preorder,mp,start,i-1,idx+1);
        root.right = solve(preorder,mp,i+1,end,idx+(i-start)+1);
        return root;
    }
}

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        return solve(preorder,inorder,0,n-1,0);
    }
    public TreeNode solve(int [] preorder, int [] inorder, int start, int end, int idx){
        if(start>end) return null;
        int rootval = preorder[idx];
        int i = start;
        for(;i<=end;i++) if(inorder[i]==rootval) break;
        TreeNode root = new TreeNode(rootval);
        root.left = solve(preorder,inorder,start,i-1,idx+1);
        root.right = solve(preorder,inorder,i+1,end,idx+(i-start)+1);
        return root;
    }
}