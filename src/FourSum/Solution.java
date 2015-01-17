package FourSum;

import java.util.*;
import java.util.stream.Collectors;

/**
 * User: Danyang
 * Date: 1/17/2015
 * Time: 15:23
 *
 * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

 Note:
 Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
 The solution set must not contain duplicate quadruplets.
 For example, given array S = {1 0 -1 0 -2 2}, and target = 0.

 A solution set is:
 (-1,  0, 0, 1)
 (-2, -1, 1, 2)
 (-2,  0, 0, 2)

 */
public class Solution {
    /**
     * Brute force O(n^4)
     * Two pointers O(n^3)
     * HashMap O(n^2)
     *
     * Notice:
     * 1. de-duplicate
     * 2. keep index rather than keep value
     * 3. handle [0, 0, 0, 0]
     * @param num
     * @param target
     * @return
     */
    public List<List<Integer>> fourSum(int[] num, int target) {
        Arrays.sort(num);
        Map<Integer, List<List<Integer>>> sum2pairs = new HashMap<>();
        for(int i=0; i<num.length; i++) {
            for(int j=i+1; j<num.length; j++) {
                int sum = num[i]+num[j];
                List<Integer> pair = new ArrayList<>();
                pair.add(i);
                pair.add(j);
                if(!sum2pairs.containsKey(sum)) {
                    sum2pairs.put(sum, new ArrayList<>());
                }
                sum2pairs.get(sum).add(pair);
            }
        }

        Set<List<Integer>> ret = new HashSet<>();
        for(int i=0; i<num.length; i++) {
            for(int j=i+1; j<num.length; j++) {
                int sum_first = num[i]+num[j];
                int sum_second = target-sum_first;
                if(sum2pairs.containsKey(sum_second)) {
                    for(List<Integer> pair: sum2pairs.get(sum_second)) {
                        if(pair.get(0)>j) {
                            ret.add(Arrays.asList(num[i], num[j], num[pair.get(0)], num[pair.get(1)]));
                        }
                    }
                }
            }
        }
        return ret.stream().collect(Collectors.toList());
    }
}