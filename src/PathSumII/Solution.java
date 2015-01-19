package PathSumII;

import commons.datastructures.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * User: Danyang
 * Date: 1/19/2015
 * Time: 19:51
 */
public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ret = new ArrayList<>();
        dfs(root, new ArrayList<>(), sum, ret);
        return ret;
    }

    void dfs(TreeNode c, List<Integer> cur, int remain, List<List<Integer>> ret) {
        if(c==null)
            return;

        remain -= c.val;
        cur.add(c.val);
        if(remain==0 && c.left==null && c.right==null) {
            List<Integer> t = new ArrayList<>();
            t.addAll(cur);
            ret.add(t);
        }
        dfs(c.left, cur, remain, ret);
        dfs(c.right, cur, remain, ret);
        cur.remove(cur.size()-1);
    }
}