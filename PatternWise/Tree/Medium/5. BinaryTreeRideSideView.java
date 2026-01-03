// https://leetcode.com/problems/binary-tree-right-side-view/description/

class Solution { //preorder dfs
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ls = new ArrayList<>();
        help(root,ls,1);
        return ls;
    }
    public void help(TreeNode root,List<Integer> ls, int level){
        if(root==null) return;
        if(ls.size()<level) ls.add(root.val);
        help(root.right,ls,level+1);
        help(root.left,ls,level+1);
    }
}

class Solution { //levelorder bfs
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if(root==null){
            return ans;
        }
        q.add(root);
        while(q.size()>0){
            List<Integer> level = new ArrayList<>();
            int len = q.size();
            for(int i=1;i<=len;i++){
                TreeNode n = q.poll();
                level.add(n.val);
                if(n.left!=null){
                    q.add(n.left);
                }
                if(n.right!=null){
                    q.add(n.right);
                }
            }
            ans.add(level.get(level.size()-1));
        }
        return ans;
    }
}