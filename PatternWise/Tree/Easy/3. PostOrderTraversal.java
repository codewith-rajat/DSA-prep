// https://www.geeksforgeeks.org/problems/postorder-traversal/1

class Solution {
    public ArrayList<Integer> postOrder(Node root) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        help(ans,root);
        return ans;
    }
    public static void help(ArrayList<Integer> ans, Node root){
        if(root==null) return;
        help(ans,root.left);
        help(ans,root.right);
        ans.add(root.data);
    }
}