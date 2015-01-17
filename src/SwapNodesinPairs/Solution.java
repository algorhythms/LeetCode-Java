package SwapNodesinPairs;

import commons.datastructures.ListNode;


/**
 * User: Danyang
 * Date: 1/17/2015
 * Time: 21:15
 */
public class Solution {
    /**
     * Draw a diagram
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        while(pre.next!=null && pre.next.next!=null) {
            ListNode cur = pre.next;
            ListNode next = cur.next;
            ListNode nextNext = next.next;

            pre.next = next;
            next.next = cur;
            cur.next = nextNext;
            pre = pre.next.next;
        }
        return dummy.next;
    }
}