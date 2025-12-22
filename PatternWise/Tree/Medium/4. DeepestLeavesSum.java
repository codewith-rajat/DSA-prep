// http://leetcode.com/problems/deepest-leaves-sum/description/?envType=problem-list-v2&envId=depth-first-search

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int deepestLeavesSum(TreeNode root) {
        int maxx = maxDepth(root);
        int ans = dfs(root,1,maxx);
        return ans;
    }
    public int dfs(TreeNode root, int curr, int maxx){
        if(root==null) return 0;
        if(curr==maxx) return root.val;
        int left = dfs(root.left,curr+1,maxx);
        int right = dfs(root.right,curr+1,maxx);
        return left + right;
    }
    public int maxDepth(TreeNode root){
        if(root==null) return 0;
        int lh = maxDepth(root.left);
        int rh = maxDepth(root.right);
        return 1 + Math.max(lh,rh);
    }
}