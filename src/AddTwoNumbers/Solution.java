package AddTwoNumbers;

import commons.datastructures.ListNode;

/**
 * User: Danyang
 * Date: 1/14/2015
 * Time: 21:44
 *
 * ou are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each
 * of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 *
     Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
     Output: 7 -> 0 -> 8
 */

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode c1 = l1;
        ListNode c2 = l2;
        ListNode head = new ListNode(0);
        ListNode c = head;
        int carry = 0;
        while(c1!=null && c2!=null) {
            int sum = c1.val+c2.val+carry;
            c.val = sum%10;

            carry = sum/10;
            if(c1.next!=null||c2.next!=null||carry>0) {
                c.next = new ListNode(0);
            }
            c = c.next;
            c1 = c1.next;
            c2 = c2.next;
        }
        if(c2!=null)
            c1 = c2;

        while(c1!=null) {
            int sum = c1.val+carry;
            c.val = sum%10;

            carry = sum/10;
            if(c1.next!=null||carry>0) {
                c.next = new ListNode(0);
            }
            c = c.next;
            c1 = c1.next;
        }
        if(carry!=0) {
            c.val = carry;
        }

        return head;
    }
}