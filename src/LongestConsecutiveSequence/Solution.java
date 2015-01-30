package LongestConsecutiveSequence;

import java.util.HashSet;
import java.util.Set;

/**
 * User: Danyang
 * Date: 1/30/2015
 * Time: 21:48
 *
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

 For example,
 Given [100, 4, 200, 1, 3, 2],
 The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

 Your algorithm should run in O(n) complexity.
 */
public class Solution {
    /**
     * Algorithm: pivoting, kind of 1-D dfs
     * @param num
     * @return
     */
    public int longestConsecutive(int[] num) {
        Set<Integer> nums = new HashSet<>();
        for(int i=0; i<num.length; i++)
            nums.add(num[i]);
        Set<Integer> visited = new HashSet<>();
        int gmax = 0;
        for(int i=0; i<num.length; i++) {
            if(visited.contains(num[i]))
                continue;
            visited.add(num[i]);
            int len = 1;
            int right = num[i]+1;
            while(!visited.contains(right) && nums.contains(right)) {
                visited.add(right);
                right++;
                len++;
            }
            int left = num[i]-1;
            while(!visited.contains(left) && nums.contains(left)) {
                visited.add(left);
                left--;
                len++;
            }
            gmax = Math.max(gmax, len);
        }
        return gmax;
    }
}