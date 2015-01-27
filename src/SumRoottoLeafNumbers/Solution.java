package SumRoottoLeafNumbers;

import commons.datastructures.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * User: Danyang
 * Date: 1/27/2015
 * Time: 15:22
 *
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

 An example is the root-to-leaf path 1->2->3 which represents the number 123.

 Find the total sum of all root-to-leaf numbers.

 For example,

   1
  / \
 2   3
 The root-to-leaf path 1->2 represents the number 12.
 The root-to-leaf path 1->3 represents the number 13.

 Return the sum = 12 + 13 = 25.
 */
public class Solution {
    public int sumNumbers(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        dfs(root, 0, ret);
        return ret.stream().mapToInt(e->e).sum();
    }

    void dfs(TreeNode c, int cur, List<Integer> ret) {
        if(c==null)
            return ;
        cur = cur*10+c.val;
        if(c.right==null && c.left==null)
            ret.add(cur);
        if(c.right!=null) dfs(c.right, cur, ret);
        if(c.left!=null) dfs(c.left, cur, ret);
    }
}