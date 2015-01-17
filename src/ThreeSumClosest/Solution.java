package ThreeSumClosest;

import java.util.Arrays;

/**
 * User: Danyang
 * Date: 1/17/2015
 * Time: 13:10
 *
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target.
 * Return the sum of the three integers. You may assume that each input would have exactly one solution.

 For example, given array S = {-1 2 1 -4}, and target = 1.

 The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */
public class Solution {
    /**
     * Two Pointers
     *
     * @param num
     * @return
     */
    public int threeSumClosest(int[] num, int target) {
        Arrays.sort(num);
        int n = num.length;
        int sum_min = num[0]+num[1]+num[2];

        for(int i=0; i<n-2; ) {
            int j = i+1;
            int k = n-1;
            while(j<k) {
                int sum = num[i]+num[j]+num[k];
                if(Math.abs(sum_min-target)>Math.abs(sum-target))
                    sum_min = sum;

                if(sum==target) {
                    return target;
                }
                else if(sum>target)
                    k--;
                else
                    j++;
            }
            i++;
            while(i<n-2 && num[i]==num[i-1])
                i++;
        }
        return sum_min;
    }
}