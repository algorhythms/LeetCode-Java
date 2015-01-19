package SymmetricTree;

import commons.datastructures.TreeNode;

/**
 * User: Danyang
 * Date: 1/19/2015
 * Time: 19:21
 *
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 */
public class Solution {
    /**
     * iterative: bfs, array sysmetric
     * recursive: drawing the tree
     *           1
     *        2     2
     *      3  4  4   3
     *    5 6 7 88 7 6 5
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if(root==null)
            return true;
        return isSymmetric(root.left, root.right);
    }

    boolean isSymmetric(TreeNode l, TreeNode r) {
        if(l==null&&r==null)
            return true;
        try {
            return l.val==r.val && isSymmetric(l.left, r.right) && isSymmetric(l.right, r.left);
        }
        catch(Exception e) {
            return false;
        }
    }
}