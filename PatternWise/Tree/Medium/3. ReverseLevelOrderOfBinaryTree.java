// https://leetcode.com/problems/reverse-odd-levels-of-binary-tree/description/?envType=problem-list-v2&envId=depth-first-search

class Solution {
    public TreeNode reverseOddLevels(TreeNode root) {
        Queue<TreeNode> pq = new LinkedList<>();
        pq.add(root);
        int l = 0;
        while(!pq.isEmpty()){
            int size = pq.size();
            List<TreeNode> level = new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode n = pq.poll();
                level.add(n);
                if(n.left!=null) pq.add(n.left); 
                if(n.right!=null) pq.add(n.right); 
            }
            if(l%2==1){
                int i = 0,j = level.size()-1;
                while(i<j){
                    int v = level.get(i).val;
                    level.get(i).val = level.get(j).val;
                    level.get(j).val = v;
                    i++;
                    j--;
                }
            }
            l++;
        }
        return root;
    }
}