package RemoveNthNodeFromEndofList;

import commons.datastructures.ListNode;

/**
 * User: Danyang
 * Date: 1/17/2015
 * Time: 17:00
 *
 * Given a linked list, remove the nth node from the end of list and return its head.

 For example,

 Given linked list: 1->2->3->4->5, and n = 2.

 After removing the second node from the end, the linked list becomes 1->2->3->5.
 Note:
 Given n will always be valid.
 Try to do this in one pass.

 */

public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int l = getLength(head);
        int pos = l-n;
        if(pos<0)
            return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode pre = dummy;
        int i = 0;
        while(pre.next!=null) {
            ListNode cur = pre.next;
            if(i==pos) {
                pre.next = cur.next;
                break;
            }
            pre = pre.next;
            i++;
        }
        return dummy.next;
    }

    int getLength(ListNode head) {
        ListNode cur = head;
        int cnt = 0;
        while(cur!=null) {
            cnt++;
            cur = cur.next;
        }
        return cnt;
    }
}