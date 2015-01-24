package Combinations;

import java.util.ArrayList;
import java.util.List;

/**
 * User: Danyang
 * Date: 1/24/2015
 * Time: 11:05
 *
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

 For example,
 If n = 4 and k = 2, a solution is:

 [
 [2,4],
 [3,4],
 [2,3],
 [1,2],
 [1,3],
 [1,4],
 ]
 */
public class Solution {
    /**
     * Notice:
     * 1. debug recursive
     * @param n
     * @param k
     * @return
     */
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ret = new ArrayList<>();
        dfs(n, k, 1, new ArrayList<>(), ret);
        return ret;
    }

    void dfs(int n, int k, int next, List<Integer> cur, List<List<Integer>> ret) {
        if(cur.size()>k)
            return ;
        if(cur.size()==k) {
            ret.add(new ArrayList<>(cur));
            return ;
        }
        for(int i=next; i<=n; i++) {
            cur.add(i);
            dfs(n, k, i+1, cur, ret);
            cur.remove(cur.size()-1);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> ret = new Solution().combine(4, 2);
        System.out.println(ret);
    }
}