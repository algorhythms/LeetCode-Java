package BinaryTreePreorderTraversal;

import commons.datastructures.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * User: Danyang
 * Date: 1/27/2015
 * Time: 10:34
 * Given a binary tree, return the preorder traversal of its nodes' values.

 For example:
 Given binary tree {1,#,2,3},
 1
 \
  2
 /
 3
 return [1,2,3].

 Note: Recursive solution is trivial, could you do it iteratively?
 */
public class Solution {
    /**
     * Pre-order: c L R
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> stk = new Stack<>();
        List<Integer> ret = new ArrayList<>();
        if(root==null)
            return ret;

        stk.add(root);
        while(!stk.empty()) {
            TreeNode cur = stk.pop();
            ret.add(cur.val);
            if(cur.right!=null)
                stk.add(cur.right);
            if(cur.left!=null)
                stk.add(cur.left);
        }
        return ret;
    }
}