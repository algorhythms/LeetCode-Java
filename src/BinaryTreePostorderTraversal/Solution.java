package BinaryTreePostorderTraversal;

import commons.datastructures.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * User: Danyang
 * Date: 1/27/2015
 * Time: 10:38
 *
 * Given a binary tree, return the postorder traversal of its nodes' values.

 For example:
 Given binary tree {1,#,2,3},
 1
 \
  2
 /
 3
 return [3,2,1].

 Note: Recursive solution is trivial, could you do it iteratively?
 */
public class Solution {
    /**
     * Post order L R c
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        Stack<TreeNode> stk = new Stack<>();
        if(root==null)
            return ret;
        stk.add(root);
        while(!stk.empty()) {
            TreeNode cur = stk.pop();
            ret.add(0, cur.val);
            if(cur.left!=null)
                stk.add(cur.left);
            if(cur.right!=null)
                stk.add(cur.right);
        }
        return ret;
    }
}