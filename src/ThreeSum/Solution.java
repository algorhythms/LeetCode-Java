package ThreeSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * User: Danyang
 * Date: 1/17/2015
 * Time: 13:10
 *
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in
 * the array which gives the sum of zero.

 Note:
 Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
 The solution set must not contain duplicate triplets.
 For example, given array S = {-1 0 1 2 -1 -4},

 A solution set is:
 (-1, 0, 1)
 (-1, -1, 2)
 */
public class Solution {
    /**
     * Two Pointers
     * You need to ask a lots of questions
     * Notice:
     * 1. jump
     * 2. don't box num
     *
     * @param num
     * @return
     */
    public List<List<Integer>> threeSum(int[] num) {
        List<List<Integer>> ret = new ArrayList<>();
        Arrays.sort(num);
        int n = num.length;
        for(int i=0; i<n-2; ) {
            int j = i+1;
            int k = n-1;
            while(j<k) {
                int sum = num[i]+num[j]+num[k];
                if(sum==0) {
                    ret.add(Arrays.asList(num[i], num[j], num[k]));
                    k--;
                    j++;
                    // while(k>=0&&A.get(k)==A.get(k+1))
                    while(j<k && num[k]==num[k+1])
                        k--;
                    // while(j<=n-1&&A.get(j)==A.get(j-1))
                    while(j<k && num[j]==num[j-1])
                        j++;
                }
                else if(sum>0)
                    k--;
                else
                    j++;
            }
            i++;
            while(i<n-2 && num[i]==num[i-1])
                i++;
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().threeSum(new int[]{-1, 0, 1}));
    }
}