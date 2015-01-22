package PermutationsII;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * User: Danyang
 * Date: 1/22/2015
 * Time: 19:59
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.

 For example,
 [1,1,2] have the following unique permutations:
 [1,1,2], [1,2,1], and [2,1,1].
 */
public class Solution {
    public List<List<Integer>> permuteUnique(int[] num) {
        List<Integer> seq = IntStream.of(num).boxed().sorted().collect(Collectors.toList());
        List<List<Integer>> ret = new ArrayList<>();
        dfs(seq, new ArrayList<>(), ret);
        return ret;
    }

    void dfs(List<Integer> seq, List<Integer> cur, List<List<Integer>> ret) {
        if(seq.size()==0)
            ret.add(new ArrayList<>(cur));

        for(int i=0; i<seq.size(); i++) {
            if(i-1>=0 && seq.get(i-1)==seq.get(i))  // jump
                continue;
            List<Integer> next = new ArrayList<>(seq);
            Integer t = next.remove(i);
            cur.add(t);
            dfs(next, cur, ret);
            cur.remove(cur.size()-1);
        }
    }
}