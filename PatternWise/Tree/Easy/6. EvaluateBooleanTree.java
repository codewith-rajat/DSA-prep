// https://leetcode.com/problems/evaluate-boolean-binary-tree/description/?envType=problem-list-v2&envId=tree

class Solution {
    public boolean evaluateTree(TreeNode root) {
        if(root.val==0) return false;
        if(root.val==1) return true;
        boolean left = evaluateTree(root.left);
        boolean right = evaluateTree(root.right);
        if(root.val==2) return left || right;
        return left && right;          
    }
}