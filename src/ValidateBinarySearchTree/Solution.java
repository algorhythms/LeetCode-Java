package ValidateBinarySearchTree;

import commons.datastructures.TreeNode;

/**
 * User: Danyang
 * Date: 1/27/2015
 * Time: 20:52
 *
 * Given a binary tree, determine if it is a valid binary search tree (BST).

 Assume a BST is defined as follows:

 The left subtree of a node contains only nodes with keys less than the node's key.
 The right subtree of a node contains only nodes with keys greater than the node's key.
 Both the left and right subtrees must also be binary search trees.
 */
public class Solution {
    /**
     * Complexity appears to be O(n lgn), but actually O(n)
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        if(root==null)
            return true;
        TreeNode l = getMax(root.left);
        TreeNode r = getMin(root.right);
        if(l!=null && l.val>=root.val || r!=null && r.val<=root.val)
            return false;
        return isValidBST(root.left) && isValidBST(root.right);
    }

    TreeNode getMax(TreeNode cur) {
        while(cur!=null && cur.right!=null)
            cur = cur.right;
        return cur;
    }

    TreeNode getMin(TreeNode cur) {
        while(cur!=null && cur.left!=null)
            cur = cur.left;
        return cur;
    }
}