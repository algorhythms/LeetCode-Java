package UniqueBinarySearchTreesII;

import commons.datastructures.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * User: Danyang
 * Date: 1/27/2015
 * Time: 16:15
 *
 * Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.

 For example,
 Given n = 3, your program should return all 5 unique BST's shown below.
 */
public class Solution {
    /**
     * Catalan
     *
     * Notice:
     * 1. need to new the TreeNode every time in the triple for loop
     * @param n
     * @return
     */
    public List<TreeNode> generateTrees(int n) {
        return getSubs(1, n+1);
    }


    List<TreeNode> getSubs(int l, int r) {
        List<TreeNode> ret = new ArrayList<>();
        if(l>=r)
            ret.add(null);
        else {
            for(int i=l; i<r; i++) {
                List<TreeNode> subs_l = getSubs(l, i);
                List<TreeNode> subs_r = getSubs(i+1, r);
                for(TreeNode sub_l: subs_l) {
                    for (TreeNode sub_r : subs_r) {
                        TreeNode cur = new TreeNode(i);
                        cur.left = sub_l;
                        cur.right = sub_r;
                        ret.add(cur);
                    }
                }
            }
        }
        return ret;
    }
}