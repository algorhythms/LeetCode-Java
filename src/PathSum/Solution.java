package PathSum;

import commons.datastructures.TreeNode;

/**
 * User: Danyang
 * Date: 1/19/2015
 * Time: 19:33
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
 */
public class Solution {
    /**
     * dfs
     * @param root
     * @param sum
     * @return
     */
    public boolean hasPathSum_error(TreeNode root, int sum) {
        if(root==null)
            return false;
        return dfs(root, 0, sum, 0);
    }

    boolean dfs(TreeNode cur, int sum_cur, int sum, int depth) {
        if(cur==null) {
            if(sum_cur==sum&&depth>1)
                return true;
            else
                return false;
        }
        return dfs(cur.left, sum_cur+cur.val, sum, depth+1) || dfs(cur.right, sum_cur+cur.val, sum, depth+1);
    }


    public boolean hasPathSum(TreeNode root, int sum) {
        return dfs(root, sum);
    }

    /**
     * TreeNode val can be negative
     * @param c
     * @param remain
     * @return
     */
    boolean dfs(TreeNode c, int remain) {
        if(c==null)
            return false;

        remain -= c.val;

        if(remain==0&&c.left==null&&c.right==null)
            return true;

        return dfs(c.left, remain) || dfs(c.right, remain);
    }
}