// https://leetcode.com/problems/count-nodes-equal-to-average-of-subtree/description/

class Solution {
    public int averageOfSubtree(TreeNode root) {
        return solve(root)[2];
    }
    public int[] solve(TreeNode root) {
        if(root==null) return new int[]{0,0,0};
        int left[] = solve(root.left);
        int right[] = solve(root.right);
        int totalsum = root.val + left[0] + right[0];
        int count = 1 + left[1] + right[1];
        int ans = left[2] + right[2] + (totalsum/count == root.val ? 1 : 0);
        return new int[]{totalsum,count,ans};
    }
}