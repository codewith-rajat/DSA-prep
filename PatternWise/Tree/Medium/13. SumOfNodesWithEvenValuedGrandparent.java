// https://leetcode.com/problems/sum-of-nodes-with-even-valued-grandparent/description/?envType=problem-list-v2&envId=tree

class Solution {
    int ans = 0;
    public int sumEvenGrandparent(TreeNode root) {
        return solve(root,-1,-1);
    }
    public int solve(TreeNode root, int p, int gp){
        if(root==null) return 0;
        int left = solve(root.left,root.val,p);
        int right = solve(root.right,root.val,p);
        return ((gp%2==0) ? root.val : 0) + left + right; 
    }
}