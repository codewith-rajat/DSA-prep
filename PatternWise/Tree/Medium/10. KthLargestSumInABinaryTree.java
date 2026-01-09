// https://leetcode.com/problems/kth-largest-sum-in-a-binary-tree/description/

class Solution {
    public long kthLargestLevelSum(TreeNode root, int k) {
        List<Long> ls = new ArrayList<>();
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        while(q.size()>0){
            int size = q.size();
            long sum = 0;
            for(int i=0;i<size;i++){
                TreeNode node = q.poll();
                sum += node.val;
                if(node.left!=null) q.add(node.left);
                if(node.right!=null) q.add(node.right);
            }
            ls.add(sum);
        }
        Collections.sort(ls);
        return ls.size()<k ? -1 : ls.get(ls.size()-k);
    }
}

class Solution {
    public long kthLargestLevelSum(TreeNode root, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        while(q.size()>0){
            int size = q.size();
            long sum = 0;
            for(int i=0;i<size;i++){
                TreeNode node = q.poll();
                sum += node.val;
                if(node.left!=null) q.add(node.left);
                if(node.right!=null) q.add(node.right);
            }
            pq.add(sum);
        }
        while(pq.size()>k){
            pq.poll();
        }
        return pq.size()<k ? -1 : pq.peek();
    }
}