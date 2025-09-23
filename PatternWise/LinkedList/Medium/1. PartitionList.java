// https://leetcode.com/problems/partition-list

class Solution {
    public ListNode partition(ListNode head, int x) {
        if(head==null) return null;
        ListNode beforehead = new ListNode(0);
        ListNode before = beforehead;
        ListNode afterhead = new ListNode(0);
        ListNode after = afterhead;
        while(head!=null){
            int v = head.val;
            if(v<x){
                before.next = head;
                before = before.next;
            }
            else{
                after.next = head;
                after = after.next;
            }
            head = head.next;
        }
        after.next = null;
        before.next = afterhead.next;
        return beforehead.next;
    }
}