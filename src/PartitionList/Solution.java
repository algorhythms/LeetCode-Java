package PartitionList;

import commons.datastructures.ListNode;

/**
 * User: Danyang
 * Date: 1/26/2015
 * Time: 15:26
 *
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or
 * equal to x.

 You should preserve the original relative order of the nodes in each of the two partitions.

 For example,
 Given 1->4->3->2->5->2 and x = 3,
 return 1->2->2->4->3->5.
 */
public class Solution {
    /**
     * diagram
     * @param head
     * @param x
     * @return
     */
    public ListNode partition(ListNode head, int x) {
        ListNode d1 = new ListNode(0);  // dummy
        ListNode d2 = new ListNode(0);  // dummy

        ListNode p1 = d1;
        ListNode p2 = d2;
        ListNode cur = head;
        while(cur!=null) {
            if(cur.val<x) {
                p1.next = cur;
                p1 = p1.next;
            }
            else {
                p2.next = cur;
                p2 = p2.next;
            }
            cur = cur.next;
        }
        p1.next = d2.next;
        p2.next = null;
        return d1.next;
    }
}