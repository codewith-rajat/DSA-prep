// https://www.geeksforgeeks.org/problems/level-order-traversal/1

class Solution {
    public ArrayList<ArrayList<Integer>> levelOrder(Node root) {
        // code here
        Queue<Node> pq = new LinkedList<>();
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if(root==null) return ans;
        pq.add(root);
        while(!pq.isEmpty()){
            int level = pq.size();
            ArrayList<Integer> temp = new ArrayList<>();
            for(int i=0;i<level;i++){
                if(pq.peek().left!=null) pq.add(pq.peek().left);
                if(pq.peek().right!=null) pq.add(pq.peek().right);
                temp.add(pq.poll().data);
            }
            ans.add(temp);
        }
        return ans;
    }
}