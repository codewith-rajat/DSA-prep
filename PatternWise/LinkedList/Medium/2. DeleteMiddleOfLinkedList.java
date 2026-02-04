// https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/
// lc 2095
class Solution {
    public ListNode deleteMiddle(ListNode head) {
        if(head.next==null) return null;
        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = slow.next;
        return slow==head ? prev.next : head; //for 2 length
    }
}