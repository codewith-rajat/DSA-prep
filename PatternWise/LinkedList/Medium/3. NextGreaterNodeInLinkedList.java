// https://leetcode.com/problems/next-greater-node-in-linked-list/description/
// lc 1019
class Solution {
    public int[] nextLargerNodes(ListNode head) {
        int size = 0;
        ListNode temp = head;
        while(temp!=null){
            size++;
            temp = temp.next;
        }
        Stack<Integer> st = new Stack<>();
        int arr[] = new int[size];
        int i = 0;
        temp = head;
        while(temp!=null){
            arr[i++] = temp.val;
            temp = temp.next;
        }
        for(i=size-1;i>=0;i--){
            while(!st.isEmpty() && st.peek()<=arr[i]) st.pop();
            int nextgr = st.isEmpty() ? 0 : st.peek();
            st.push(arr[i]);
            arr[i] = nextgr;
        }
        return arr;
    }
}