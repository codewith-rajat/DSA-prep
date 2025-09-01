// https://leetcode.com/problems/count-complete-tree-nodes/description/

class Solution {
    public void traverse(TreeNode root,int [] a){
        if(root==null) return;
        a[0] = a[0] + 1;
        traverse(root.left,a);
        traverse(root.right,a);
    }
    public int countNodes(TreeNode root) {
        int a[] = new int[1];
        traverse(root,a);
        return a[0];
    }
}