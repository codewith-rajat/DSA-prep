// https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/?envType=daily-question&envId=2026-01-06

class Solution {
    public int maxLevelSum(TreeNode root) {
        if(root==null) return 0;
        int level = 1,maxlevel = 1,maxsum = Integer.MIN_VALUE;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(q.size()>0){
            int size = q.size();
            int sum = 0;
            for(int i=0;i<size;i++){
                TreeNode node = q.poll();
                sum += node.val;
                if(node.left!=null) q.add(node.left);
                if(node.right!=null) q.add(node.right);
            }
            if(sum>maxsum){
                maxsum = sum;
                maxlevel = level; 
            }
            level++;
        }
        return maxlevel;
    }
}