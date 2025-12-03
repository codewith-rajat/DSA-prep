// https://leetcode.com/problems/maximum-depth-of-binary-tree/description/

class Solution {
    public int maxDepth(TreeNode root) {
        int level = 0;
        Queue<TreeNode> pq = new LinkedList<>();
        if(root==null) return 0;
        pq.add(root);
        while(!pq.isEmpty()){
            int l = pq.size();
            for(int i=0;i<l;i++){
                TreeNode node = pq.poll();
                if(node.left!=null) pq.add(node.left);
                if(node.right!=null) pq.add(node.right);
            }
            level++;
        } 
        return level;
    }
}

class Solution{
    public int maxDepth(TreeNode root){
        if(root==null) return 0;
        int lh = maxDepth(root.left);
        int rh = maxDepth(root.right);
        return 1 + Math.max(lh,rh);
    }
}