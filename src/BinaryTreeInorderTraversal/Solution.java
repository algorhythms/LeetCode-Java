package BinaryTreeInorderTraversal;

import commons.datastructures.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * User: Danyang
 * Date: 1/27/2015
 * Time: 10:21
 *
 * Given a binary tree, return the inorder traversal of its nodes' values.

 For example:
 Given binary tree {1,#,2,3},
 1
 \
  2
 /
 3
 return [1,3,2].

 Note: Recursive solution is trivial, could you do it iteratively?
 */
public class Solution {
    /**
     * in-order: L c R
     * Notice:
     * 1. debugging
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal_complicated(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        Stack<TreeNode> stk = new Stack<>();
        if(root==null)
            return ret;

        TreeNode cur = root;
        while(!stk.empty() || cur!=null) {
            // L
            while(cur!=null) {
                stk.add(cur);
                cur = cur.left;
            }

            // c R
            while(!stk.empty()) {
                cur = stk.pop();
                ret.add(cur.val);
                if(cur.right!=null) {
                    cur = cur.right;
                    break;
                }
                else {
                    cur = null;
                }
            }
        }
        return ret;
    }

    /**
     * Flatten the loop
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        Stack<TreeNode> stk = new Stack<>();
        if(root==null)
            return ret;

        TreeNode cur = root;
        while(!stk.empty() || cur!=null) {
            // L
            while(cur!=null) {
                stk.add(cur);
                cur = cur.left;
            }

            // c R
            cur = stk.pop();
            ret.add(cur.val);
            cur = cur.right;
        }
        return ret;
    }
}