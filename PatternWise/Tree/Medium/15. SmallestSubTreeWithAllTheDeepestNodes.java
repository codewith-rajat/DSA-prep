// https://leetcode.com/problems/smallest-subtree-with-all-the-deepest-nodes/?envType=daily-question&envId=2026-01-09

class Solution {
    public TreeNode lca(TreeNode root, Map<Integer,Integer> mp, int d){
        if(root==null || mp.get(root.val) == d) return root;
        TreeNode left = lca(root.left,mp,d);
        TreeNode right = lca(root.right,mp,d);
        if(left != null && right!=null) return root;
        return left != null ? left : right; 
    }
    public int depth(TreeNode root, int d, Map<Integer,Integer> mp){
        if(root==null) return 0;
        mp.put(root.val,d);
        int left = depth(root.left,d+1,mp);
        int right = depth(root.right,d+1,mp);
        return 1 + Math.max(left,right);
    }
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        Map<Integer,Integer> mp = new HashMap<>();
        int d = depth(root,0,mp);
        return lca(root,mp,d-1);
    }
}