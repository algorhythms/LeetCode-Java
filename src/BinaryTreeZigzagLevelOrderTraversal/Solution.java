package BinaryTreeZigzagLevelOrderTraversal;

import commons.datastructures.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * User: Danyang
 * Date: 1/27/2015
 * Time: 16:37
 *
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then
 * right to left for the next level and alternate between).

 For example:
 Given binary tree {3,9,20,#,#,15,7},
 3
 / \
 9  20
 /  \
 15   7
 return its zigzag level order traversal as:
 [
 [3],
 [20,9],
 [15,7]
 ]
 */
public class Solution {
    /**
     * bfs
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        List<TreeNode> q = new ArrayList<>();
        if(root==null)
            return ret;
        TreeNode cur = root;
        q.add(cur);
        boolean obverse = true;
        while(!q.isEmpty()) {
            int l = q.size();
            List<Integer> level = new ArrayList<>();
            for(int i=0; i<l; i++) {
                cur = q.get(i);
                if(obverse)
                    level.add(cur.val);
                else
                    level.add(0, cur.val);
                if(cur.left!=null) q.add(cur.left);
                if(cur.right!=null) q.add(cur.right);
            }
            ret.add(level);
            obverse = !obverse;
            q = q.subList(l, q.size());
        }
        return ret;
    }
}