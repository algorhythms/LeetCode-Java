package Permutations;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * User: Danyang
 * Date: 1/20/2015
 * Time: 11:35
 *
 * Given a collection of numbers, return all possible permutations.

 For example,
 [1,2,3] have the following permutations:
 [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].

 */
public class Solution {
    public List<List<Integer>> permute(int[] num) {
        List<List<Integer>> ret = new ArrayList<>();
        dfs(IntStream.of(num).boxed().collect(Collectors.toList()), new ArrayList<>(), ret);
        return ret;
    }

    void dfs(List<Integer> seq, List<Integer> cur, List<List<Integer>> ret) {
        if(seq.size()==0)
            ret.add(new ArrayList<>(cur));

        // list manipulation is verbose
        for(int i=0; i<seq.size(); i++) {
            List<Integer> next = new ArrayList<>(seq);
            int t = next.remove(i);
            cur.add(t);
            dfs(next, cur, ret);
            cur.remove(cur.size()-1);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> ret = new Solution().permute(new int[]{0, 1});
        System.out.println(ret);
    }
}