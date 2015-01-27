package ConstructBinaryTreefromInorderandPostorderTraversal;

import commons.datastructures.TreeNode;

/**
 * User: Danyang
 * Date: 1/27/2015
 * Time: 17:10
 *
 * Given inorder and postorder traversal of a tree, construct the binary tree.

 Note:
 You may assume that duplicates do not exist in the tree.

 */
public class Solution {
    /**
     * inorder: L c R
     * postorder: L R c
     * @param inorder
     * @param postorder
     * @return
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, 0, inorder.length, postorder, 0, postorder.length);
    }

    TreeNode buildTree(int[] in, int s1, int e1, int[] post, int s2, int e2) {
        if(s1>=e1 || s2>=e2)
            return null;
        TreeNode root = new TreeNode(post[e2-1]);
        int i;
        for(i=s1; i<e1 && in[i]!=root.val; i++);
        int len_l = i-s1;
        TreeNode l = buildTree(in, s1, i, post, s2, s2+len_l);
        TreeNode r = buildTree(in, i+1, e1, post, s2+len_l, e2-1);
        root.left = l;
        root.right = r;
        return root;
    }
}