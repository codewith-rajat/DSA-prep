// https://leetcode.com/problems/maximum-binary-tree/description/?envType=problem-list-v2&envId=tree

class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        Stack<TreeNode> st = new Stack<>();
        for(int i : nums){
            TreeNode node = new TreeNode(i);
            while(!st.isEmpty() && st.peek().val < i){
                node.left = st.pop();
            }
            if(!st.isEmpty()) st.peek().right = node;
            st.push(node);
        }
        return st.firstElement();
    }
}

class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        int n = nums.length;
        return solve(nums,-1,0,n);
    }
    public TreeNode solve(int[] nums, int max, int left, int right){
        if(left>=right) return null;
        int idx = 0;
        for(int i=left;i<right;i++){
            if(nums[i]>max) {
                max = nums[i];
                idx = i;
            }
        }
        TreeNode node = new TreeNode(max);
        node.left = solve(nums,-1,left,idx);
        node.right = solve(nums,-1,idx+1,right);
        return node;
    }
}