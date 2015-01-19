package TrappingRainWater;


/**
 * User: Danyang
 * Date: 1/19/2015
 * Time: 11:36
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water
 * it is able to trap after raining.

 For example,
 Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 */
public class Solution {
    /**
     * Simple DP
     * Forward, backward scanning
     *
     * dp[i], i on index
     * O(n)
     * @param A
     * @return
     */
    public int trap(int[] A) {
        if(A==null || A.length==0)
            return 0;

        int [] max_r = new int[A.length];  // from right
        int [] max_l = new int[A.length];  // from left

        max_l[0] = A[0];
        for(int i=1; i<A.length; i++)
            max_l[i] = Math.max(max_l[i-1], A[i]);

        max_r[A.length-1] = A[A.length-1];
        for(int i=A.length-2; i>-1; i--)
            max_r[i] = Math.max(max_r[i+1], A[i]);

        int ret = 0;
        for(int i=1; i<A.length-1; i++) {
            ret += Math.max(0, Math.min(max_l[i-1], max_r[i+1])-A[i]);
        }
        return ret;
    }

    public static void main(String[] args) {
        int ret = new Solution().trap(new int[] {2, 0, 2});
        System.out.println(ret);
    }
}