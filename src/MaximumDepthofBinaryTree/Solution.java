package MaximumDepthofBinaryTree;

import commons.datastructures.TreeNode;

/**
 * User: Danyang
 * Date: 1/27/2015
 * Time: 15:17
 *
 * Given a binary tree, find its maximum depth.

 The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 */
public class Solution {
    public int maxDepth(TreeNode root) {
        if(root==null)
            return 0;
        return getDepth(root, 1);
    }

    int getDepth(TreeNode cur, int depth) {
        if(cur==null)
            return Integer.MIN_VALUE;
        if(cur.left==null && cur.right==null)
            return depth;
        return Math.max(getDepth(cur.left, depth+1), getDepth(cur.right, depth+1));
    }
}