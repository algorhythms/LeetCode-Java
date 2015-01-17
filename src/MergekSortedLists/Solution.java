package MergekSortedLists;

import commons.datastructures.ListNode;

import java.util.List;
import java.util.PriorityQueue;

/**
 * User: Danyang
 * Date: 1/17/2015
 * Time: 20:38
 *
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 */
public class Solution {
    /**
     * Heap With ListNode
     * m lists, with n nodes each
     * O(lg m * mn)
     *
     *  -------------------
         |  |  |  |  |  |
         |  |  |  |  |  |
         |  |  |  |  |  |
         |  |  |  |  |  |
     *
     *
     * @param lists
     * @return
     */
    public ListNode mergeKLists(List<ListNode> lists) {
        ListNode dummy = new ListNode(0);
        PriorityQueue<ListNode> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.val, o2.val));
        for(ListNode cur: lists) {  // stream may TLE
            if(cur!=null)
                pq.add(cur);
        }
        ListNode pre = dummy;
        while(pq.size()>0) {
            ListNode cur = pq.poll();
            if(cur.next!=null)
                pq.add(cur.next);
            pre.next = cur;
            pre = pre.next;
        }
        return dummy.next;
    }
}