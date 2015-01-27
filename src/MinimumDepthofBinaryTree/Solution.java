package MinimumDepthofBinaryTree;

import commons.datastructures.TreeNode;

/**
 * User: Danyang
 * Date: 1/27/2015
 * Time: 15:11
 *
 * Given a binary tree, find its minimum depth.

 The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

 */
public class Solution {
    /**
     * Notice:
     * 1. must be leaf node
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        if(root==null)
            return 0;
        return getDepth(root, 1);
    }

    int getDepth(TreeNode cur, int depth) {
        if(cur==null)
            return Integer.MAX_VALUE;
        if(cur.left==null && cur.right==null)
            return depth;
        return Math.min(getDepth(cur.left, depth+1), getDepth(cur.right, depth+1));
    }
}