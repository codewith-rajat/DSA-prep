// https://www.geeksforgeeks.org/problems/left-view-of-binary-tree/1

class Solution {
    public ArrayList<Integer> leftView(Node root) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        if(root==null){
            return ans;
        }
        q.add(root);
        while(q.size()>0){
            List<Integer> level = new ArrayList<>();
            int len = q.size();
            for(int i=1;i<=len;i++){
                Node n = q.poll();
                level.add(n.data);
                if(n.left!=null){
                    q.add(n.left);
                }
                if(n.right!=null){
                    q.add(n.right);
                }
            }
            ans.add(level.get(0));
        }
        return ans;
    }
}