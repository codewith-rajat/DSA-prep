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

class Solution {
    public ArrayList<Integer> preOrder(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if(root==null) return ans;
        ArrayDeque<Node> st = new ArrayDeque<>();
        st.push(root);
        while(!st.isEmpty()){
            root = st.pop();
            ans.add(root.data);
            if(root.right!=null) st.push(root.right);
            if(root.left!=null) st.push(root.left);
        }
        return ans;
    }
}