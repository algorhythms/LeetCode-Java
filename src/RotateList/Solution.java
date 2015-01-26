package RotateList;

import commons.datastructures.ListNode;

/**
 * User: Danyang
 * Date: 1/26/2015
 * Time: 11:40
 *
 * Given a list, rotate the list to the right by k places, where k is non-negative.

 For example:
 Given 1->2->3->4->5->NULL and k = 2,
 return 4->5->1->2->3->NULL.
 */
public class Solution {
    /**
     * LinkedList, diagram
     * Notice:
     * 1. n = n%l;
     * @param head
     * @param n
     * @return
     */
    public ListNode rotateRight(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;

        int cnt = 0;
        int l = getLength(head);
        if(l==0)
            return head;
        n = n%l;
        ListNode pre_br = new ListNode(0);
        ListNode last = new ListNode(0);
        while(pre.next!=null) {
            cnt++;
            if(cnt==l-n)
                pre_br = pre.next;
            pre = pre.next;
            if(pre.next==null)
                last = pre;
        }

        last.next = dummy.next;
        dummy.next = pre_br.next;
        pre_br.next = null;
        return dummy.next;
    }

    int getLength(ListNode head) {
        ListNode cur = head;
        int l = 0;
        while(cur!=null) {
            l++;
            cur = cur.next;
        }
        return l;
    }
}