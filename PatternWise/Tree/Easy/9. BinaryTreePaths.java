// https://leetcode.com/problems/binary-tree-paths/description/?envType=problem-list-v2&envId=tree

class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ls = new ArrayList<>();
        solve(root,ls,new StringBuilder());
        return ls;
    }
    public void solve(TreeNode root, List<String> ls, StringBuilder sb){
        if(root==null) {
            ls.add(sb.toString());
            return;
        }
        sb.append(root.val);
        sb.append('-');
        sb.append('>');
        solve(root.left,ls,sb);
        sb.deleteCharAt(sb.length()-1);
        solve(root.left,ls,sb);
    }
}