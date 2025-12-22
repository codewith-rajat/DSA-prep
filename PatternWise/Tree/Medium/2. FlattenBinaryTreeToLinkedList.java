// https://leetcode.com/problems/flatten-binary-tree-to-linked-list/description/

class Solution {
    public void flatten(TreeNode root) {
        if(root==null) return;
        List<TreeNode> l = new ArrayList<>();
        dfs(root,l);
        for(int i=1;i<l.size();i++){
            TreeNode prev = l.get(i-1);
            TreeNode curr = l.get(i);
            prev.left=null;
            prev.right=curr;
        }
    }
    public void dfs(TreeNode node,List<TreeNode> l){
        l.add(node);
        if(node.left!=null) dfs(node.left,l);
        if(node.right!=null) dfs(node.right,l);
    }
}