// https://leetcode.com/problems/find-elements-in-a-contaminated-binary-tree/?envType=problem-list-v2&envId=tree

class FindElements {
    Set<Integer> set = new HashSet<>();
    public FindElements(TreeNode root) {
        if(root==null) return;
        recover(root,0);
    }
    public void recover(TreeNode node, int val){
        if(node == null) return;
        node.val = val;
        set.add(val);
        recover(node.left,2*val+1);
        recover(node.right,2*val+2);
    }
    
    public boolean find(int target) {
        return set.contains(target);
    }
}
