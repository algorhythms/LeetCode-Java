package BalancedBinaryTree;

import commons.datastructures.TreeNode;

/**
 * User: Danyang
 * Date: 1/27/2015
 * Time: 0:10
 *
 * Given a binary tree, determine if it is height-balanced.

 For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of
 every node never differ by more than 1.
 */
public class Solution {
    /**
     * O(n lgn)?
     * Actually it is O(n)
     * \sum_{i=0}^{h-1} 2^i (h-i)
     * @param root
     * @return
     */
    public boolean isBalanced_suboptimal(TreeNode root) {
        if(root==null)
            return true;
        int depth_l = getDepth(root.left, 0);
        int depth_r = getDepth(root.right, 0);
        if(Math.abs(depth_l-depth_r)>1)
            return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }

    int getDepth(TreeNode root, int depth) {
        if(root==null)
            return depth;
        return Math.max(getDepth(root.left, depth+1), getDepth(root.right, depth+1));
    }

    /**
     * O(n)
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        int h = getHeightIfBalanced(root);
        if(h==-1)
            return false;
        return true;
    }

    /**
     * height and balanced simultaneously
     * Notice:
     * 1. -1 for not balanced
     * 2. return Math.max(l, r)+1;  // notice +1
     * @param node
     * @return
     */
    int getHeightIfBalanced(TreeNode node) {
        if(node==null)
            return 0;
        int l = getHeightIfBalanced(node.left);
        int r = getHeightIfBalanced(node.right);
        if(l==-1 || r==-1)
            return -1;
        if(Math.abs(r-l)>1)
            return -1;
        return Math.max(l, r)+1;
    }
}