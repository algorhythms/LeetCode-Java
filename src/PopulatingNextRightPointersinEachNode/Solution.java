package PopulatingNextRightPointersinEachNode;

import commons.datastructures.TreeLinkNode;

/**
 * User: Danyang
 * Date: 1/27/2015
 * Time: 21:49
 *
 * Given a binary tree

 Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be
 set to NULL.

 Initially, all next pointers are set to NULL.

 Note:

 You may only use constant extra space.
 You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two
 children).
 For example,
 Given the following perfect binary tree,
     1
   /  \
  2    3
 / \  / \
 4  5  6  7
 After calling your function, the tree should look like:
     1 -> NULL
   /  \
  2 -> 3 -> NULL
 / \  / \
 4->5->6->7 -> NULL
 */
public class Solution {
    /**
     * bfs is trivial
     * but require constant space thus can only dfs
     *
     *
     * Algorithm:
     * Since full binary tree, it relies on parent's next
     *
     * Notice:
     * 1. pre-order recursive traversal can be converted to iterative
     * 2. keep as few iterators as possible
     * @param root
     */
    public void connect_recur(TreeLinkNode root) {
        if(root==null)
            return;
        if(root.left!=null)
            root.left.next = root.right;
        if(root.right!=null && root.next!=null)
            root.right.next = root.next.left;
        connect_recur(root.left);
        connect_recur(root.right);
    }

    public void connect(TreeLinkNode root) {
        if(root==null)
            return ;
        for(TreeLinkNode p=root; p!=null; p=p.left ) {  // vertical
            for(TreeLinkNode cur=p; cur!=null; cur=cur.next) {  // horizontal
                if(cur.left!=null)
                    cur.left.next = cur.right;
                if(cur.right!=null && cur.next!=null)
                    cur.right.next = cur.next.left;
            }
        }
    }
}