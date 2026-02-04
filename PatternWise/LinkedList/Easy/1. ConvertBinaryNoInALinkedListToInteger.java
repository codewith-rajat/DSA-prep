// https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/
// lc 1290

class Solution {
    public int getDecimalValue(ListNode head) {
        int num = 0;
        while(head!=null){
            num  = num * 2 + head.val;
            head = head.next;
        }
        return num;
    }
}