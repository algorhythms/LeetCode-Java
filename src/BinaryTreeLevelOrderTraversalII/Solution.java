package BinaryTreeLevelOrderTraversalII;

import commons.datastructures.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * User: Danyang
 * Date: 1/27/2015
 * Time: 15:03
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level
 * by level from leaf to root).

 For example:
 Given binary tree {3,9,20,#,#,15,7},
  3
 / \
 9  20
 /  \
 15   7
 return its bottom-up level order traversal as:
 [
 [15,7],
 [9,20],
 [3]
 ]
 */
public class Solution {
    /**
     * bfs
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        List<TreeNode> q = new ArrayList<>();
        if(root==null)
            return ret;

        TreeNode cur = root;
        q.add(cur);
        while(!q.isEmpty()) {
            int l = q.size();
            List<Integer> level = new ArrayList<>();
            for(int i=0; i<l; i++) {
                cur = q.get(i);
                level.add(cur.val);
                if(cur.left!=null) q.add(cur.left);
                if(cur.right!=null) q.add(cur.right);
            }
            ret.add(0, level);
            q = q.subList(l, q.size());
        }
        return ret;
    }
}