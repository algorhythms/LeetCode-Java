package ConstructBinaryTreefromPreorderandInorderTraversal;

import commons.datastructures.TreeNode;

/**
 * User: Danyang
 * Date: 1/27/2015
 * Time: 16:50
 *
 * Given preorder and inorder traversal of a tree, construct the binary tree.

 Note:
 You may assume that duplicates do not exist in the tree.
 */
public class Solution {
    /**
     * preorder c L R
     * inorder L c R
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }

    TreeNode buildTree(int[] preorder, int s1, int e1, int[] inorder, int s2, int e2) {
        if(s1>=e1 || s2>=e2)
            return null;
        TreeNode root = new TreeNode(preorder[s1]);
        int i = s2;
        for(; i<e2 && inorder[i]!=root.val; i++);
        int len_l = i-s2;
        TreeNode l = buildTree(preorder, s1+1, s1+1+len_l, inorder, s2, i);
        TreeNode r = buildTree(preorder, s1+1+len_l, e1, inorder, i+1, e2);
        root.left = l;
        root.right = r;
        return root;
    }
}