package MergeTwoSortedLists;

import commons.datastructures.ListNode;

/**
 * User: Danyang
 * Date: 1/20/2015
 * Time: 10:40
 *
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
 */
public class Solution {
    /**
     * Notice:
     * 1. importance of using pre
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode c1 = l1;
        ListNode c2 = l2;
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;
        while(c1!=null && c2!=null) {
            pre.next = new ListNode(0);
            ListNode c = pre.next;
            if(c1.val<c2.val) {
                c.val = c1.val;
                c1 = c1.next;
            }
            else {
                c.val = c2.val;
                c2 = c2.next;
            }
            pre = pre.next;
        }
        if(c1==null)
            pre.next = c2;
        else
            pre.next = c1;

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode ret = new Solution().mergeTwoLists(null, null);
    }
}