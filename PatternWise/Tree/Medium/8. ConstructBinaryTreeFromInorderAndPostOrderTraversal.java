// https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/

class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer,Integer> mp = new HashMap<>();
        for(int i=0;i<inorder.length;i++) mp.put(inorder[i],i);
        return solve(postorder,mp,0,postorder.length-1,postorder.length-1);
    }
    public TreeNode solve(int[] postorder, Map<Integer,Integer> mp, int start, int end, int idx){
        if(start>end) return null;
        int rootval = postorder[idx];
        int i = mp.get(rootval);
        TreeNode root = new TreeNode(rootval);
        root.right = solve(postorder,mp,i+1,end,idx-1);
        root.left = solve(postorder,mp,start,i-1,idx-(end-i)-1);
        return root;
    }
}