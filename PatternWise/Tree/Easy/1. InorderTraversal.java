// https://www.geeksforgeeks.org/problems/inorder-traversal/1

class Solution {
    public ArrayList<Integer> inOrder(Node root) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        help(root,ans);
        return ans;
    }
    public static void help(Node root,ArrayList<Integer> ans){
        if(root==null) return;
        help(root.left,ans);
        ans.add(root.data);
        help(root.right,ans);
    }
}