package JumpGame;

/**
 * User: Danyang
 * Date: 1/17/2015
 * Time: 23:32
 *
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.

     Each element in the array represents your maximum jump length at that position.

     Determine if you are able to reach the last index.

     For example:
     A = [2,3,1,1,4], return true.

     A = [3,2,1,0,4], return false.

 */
public class Solution {
    /**
     * DP Greedy
     * f[i] the max length at index i can jump
     * f[i] = max(A[i]+i, f[i-1])
     *
     * Notice:
     * 1. condition for above equation
     * 2. don't use dummy
     * @param A
     * @return
     */
    public boolean canJump(int[] A) {
        if(A.length==1)
            return A[0]>=0;

        int [] f = new int[A.length];
        f[0] = A[0];
        for(int i=1; i<A.length; i++) {
            if(f[i-1]<i)
                return false;
            f[i] = Math.max(A[i]+i, f[i-1]);
            if(f[i]>=A.length-1)
                return true;
        }
        return false;
    }
    public static void main(String[] args) {
        boolean ret = new Solution().canJump(new int[]{1, 0, 2});
        assert ret;
    }
}