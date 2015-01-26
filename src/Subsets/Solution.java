package Subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * User: Danyang
 * Date: 1/26/2015
 * Time: 13:51
 *
 * Given a set of distinct integers, S, return all possible subsets.

 Note:
 Elements in a subset must be in non-descending order.
 The solution set must not contain duplicate subsets.
 For example,
 If S = [1,2,3], a solution is:

 [
 [3],
 [1],
 [2],
 [1,2,3],
 [1,3],
 [2,3],
 [1,2],
 []
 ]
 */
public class Solution {
    /**
     * Tree
     * Notice:
     * 1. add at leaves
     * @param S
     * @return
     */
    public List<List<Integer>> subsets(int[] S) {
        Arrays.sort(S);
        List<List<Integer>> ret = new ArrayList<>();
        dfs(S, 0, new ArrayList<>(), ret);
        return ret;
    }

    void dfs(int[] S, int i, List<Integer> cur, List<List<Integer>> ret) {
        if(i==S.length)
            ret.add(new ArrayList<>(cur));
        if(i<S.length) {
            dfs(S, i+1, cur, ret);
            cur.add(S[i]);
            dfs(S, i+1, cur, ret);
            cur.remove(cur.size()-1);
        }
    }
}