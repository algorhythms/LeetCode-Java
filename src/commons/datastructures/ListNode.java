package commons.datastructures;

/**
 * User: Danyang
 * Date: 1/17/2015
 * Time: 17:02
 */
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) {
        val = x;
        next = null;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                '}';
    }
}