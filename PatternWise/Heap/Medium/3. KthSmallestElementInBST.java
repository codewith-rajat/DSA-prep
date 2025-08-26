// https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/ 27-8-25

class Solution {
    public void help(TreeNode root,List<Integer> ans){
        if(root == null) return;
        help(root.left,ans);
        ans.add(root.val);
        help(root.right,ans);
    }
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> ans = new ArrayList<>();
        help(root,ans);
        return ans.get(k-1);
    }
}