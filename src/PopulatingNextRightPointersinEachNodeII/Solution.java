package PopulatingNextRightPointersinEachNodeII;

import commons.datastructures.TreeLinkNode;

/**
 * User: Danyang
 * Date: 1/27/2015
 * Time: 22:51
 * Follow up for problem "Populating Next Right Pointers in Each Node".

 What if the given tree could be any binary tree? Would your previous solution still work?

 Note:

 You may only use constant extra space.
 For example,
 Given the following binary tree,
    1
  /  \
 2    3
 / \    \
 4   5    7
 After calling your function, the tree should look like:
     1 -> NULL
   /  \
  2 -> 3 -> NULL
 / \    \
4-> 5 -> 7 -> NULL
 */
public class Solution {
    /**
     * more handling than Populating Next Right Pointers in Each Node
     *
     * Notice:
     * 1. must go to right sub-tree first; consider the example - bottom level only have two nodes: leftmost and rightmost
     * 2. recursive solution can be converted to iterative solution
     * 3. Is iterative solution not affected by traversing right subtree first as in recursive solution? Need
     * modification of the way of going to next level.
     * @param root
     */
    public void connect_recur(TreeLinkNode root) {
        if(root==null)
            return;
        if(root.left!=null) {
            if(root.right!=null)
                root.left.next = root.right;
            else
                root.left.next = getNextParentNextChild(root);
        }
        if(root.right!=null) {
            root.right.next = getNextParentNextChild(root);
        }

        connect_recur(root.right);
        connect_recur(root.left);
    }

    TreeLinkNode getNextParentNextChild(TreeLinkNode p) {
        p = p.next;
        while(p!=null) {
            if(p.left!=null)
                return p.left;
            else if(p.right!=null)
                return p.right;
            p = p.next;
        }
        return null;
    }

    public void connect(TreeLinkNode root) {
        if(root==null)
            return;
        for(TreeLinkNode p=root; p!=null; p=nextLevel(p)) {
            for(TreeLinkNode c=p; c!=null; c=c.next) {
                if(c.left!=null)
                    if(c.right!=null)
                        c.left.next = c.right;
                    else
                        c.left.next = getNextParentNextChild(c);
                if(c.right!=null)
                    c.right.next = getNextParentNextChild(c);
            }
        }
    }

    TreeLinkNode nextLevel(TreeLinkNode p) {
        while(p!=null) {
            if(p.left!=null)
                return p.left;
            if(p.right!=null)
                return p.right;
            p = p.next;
        }
        return null;
    }
}