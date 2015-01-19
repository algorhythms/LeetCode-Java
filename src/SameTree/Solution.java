package SameTree;

import commons.datastructures.TreeNode;

/**
 * User: Danyang
 * Date: 1/18/2015
 * Time: 13:23
 */
public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(!equal(p, q))
            return false;
        if(q!=null && p!=null && (!isSameTree(p.left, q.left) || !isSameTree(p.right, q.right)))
            return false;
        return true;
    }

    boolean equal(TreeNode p, TreeNode q) {
        if(p==null && q==null)
            return true;
        if(p!=null && q!=null && p.val==q.val)
            return true;
        return false;
    }
}