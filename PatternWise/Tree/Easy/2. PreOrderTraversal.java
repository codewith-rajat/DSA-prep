// https://www.geeksforgeeks.org/problems/preorder-traversal/1

class Solution {
    public ArrayList<Integer> preOrder(Node root) {
        //  code here
        ArrayList<Integer> ans = new ArrayList<>();
        help(ans,root);
        return ans;
    }
    public static void help(ArrayList<Integer> ans, Node root){
        if(root==null) return;
        ans.add(root.data);
        help(ans,root.left);
        help(ans,root.right);
    }
}