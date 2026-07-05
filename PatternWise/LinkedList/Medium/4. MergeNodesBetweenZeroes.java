// https://leetcode.com/problems/merge-nodes-in-between-zeros/description/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeNodes(ListNode head) {
        int sum = 0;
        ListNode slow = head, fast = head.next;
        while(fast!=null){
            if(fast.val==0) {
                slow.val = sum;
                slow = slow.next;
                fast = fast.next;
                sum = 0;
            } else {
                sum += fast.val;
                fast = fast.next;   
            }
        }
        slow.next = null;
        ListNode last = head;
        while(last.next!=slow && last.next!=null){
            last = last.next;
        }
        last.next = null;
        return head;
    }
}