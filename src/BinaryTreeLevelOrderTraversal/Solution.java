package BinaryTreeLevelOrderTraversal;

import commons.datastructures.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * User: Danyang
 * Date: 1/27/2015
 * Time: 14:56
 *
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

 For example:
 Given binary tree {3,9,20,#,#,15,7},
  3
 / \
 9  20
 /  \
 15   7
 return its level order traversal as:
 [
 [3],
 [9,20],
 [15,7]
 ]
 */
public class Solution {
    /**
     * bfs
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if(root==null)
            return ret;

        TreeNode cur = root;
        List<TreeNode> q = new ArrayList<>();
        q.add(cur);
        while(!q.isEmpty()) {
            int l = q.size();
            List<Integer> currentLevel = new ArrayList<>();
            for(int i=0; i<l; i++) {
                cur = q.get(i);
                currentLevel.add(cur.val);
                if(cur.left!=null) q.add(cur.left);
                if(cur.right!=null) q.add(cur.right);
            }
            ret.add(currentLevel);
            q = q.subList(l, q.size());  // similar API as python
        }
        return ret;
    }
}