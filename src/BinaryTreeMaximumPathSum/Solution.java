package BinaryTreeMaximumPathSum;

import commons.datastructures.TreeNode;

/**
 * User: Danyang
 * Date: 1/27/2015
 * Time: 21:18
 *
 * Given a binary tree, find the maximum path sum.

 The path may start and end at any node in the tree.

 For example:
 Given the below binary tree,

   1
  / \
 2   3
 Return 6.
 */
public class Solution {
    int gmax = Integer.MIN_VALUE;

    /**
     * Notice:
     * 1. max path end with a node
     * 2. global max may cross a node
     * @param root
     * @return
     */
    public int maxPathSum(TreeNode root) {
        if(root==null)
            return 0;
        getMaxPathEndWithCur(root);
        return gmax;
    }

    int getMaxPathEndWithCur(TreeNode cur) {
        if(cur==null)
            return 0;
        int l = getMaxPathEndWithCur(cur.left);
        int r = getMaxPathEndWithCur(cur.right);
        gmax = Math.max(gmax,
                Math.max(l+cur.val+r, Math.max(cur.val, Math.max(l+cur.val, r+cur.val)))
                );
        return Math.max(cur.val, Math.max(l+cur.val, r+cur.val));
    }
}