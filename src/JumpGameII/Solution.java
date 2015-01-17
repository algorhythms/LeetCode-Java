package JumpGameII;

/**
 * User: Danyang
 * Date: 1/17/2015
 * Time: 23:50
 *
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.

     Each element in the array represents your maximum jump length at that position.

     Your goal is to reach the last index in the minimum number of jumps.

     For example:
     Given array A = [2,3,1,1,4]

     The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
 */
public class Solution {
    /**
     * f[i] denotes the max reachable
     * f[i] = max(f[i-1], A[i]+i) if reachable from f[i-1]
     * d[i] denotes the min number of steps
     * d[i] = min(d[i-k]+1, d[i]) if reachable [forward]
     * --> d[i+k] = min(d[i]+1, d[i+k])
     *
     * O(n^2)
     * @param A
     * @return
     */
    public int jump_TLE(int[] A) {
        if(A.length==1)
            return A[0]>=0? 0: -1;

        int [] f = new int[A.length];
        int [] d = new int[A.length];
        f[0] = A[0];
        d[0] = 0;
        for(int i=1; i<A.length; i++) {
            if(i<=f[0])
                d[i] = 1;
            else
                d[i] = Integer.MAX_VALUE;
        }

        for(int i=1; i<A.length; i++) {
            if(f[i-1]<i)
                return -1;
            f[i] = Math.max(f[i-1], A[i]+i);
            for(int j=i+1; j<Math.min(A.length, f[i]+1); j++)
                d[j] = Math.min(d[j], d[i]+1);
        }
        return d[A.length-1];
    }

    /**
     * Two Pointers - Sliding Window
     * Flattened bfs
     *
     * O(n) every node is visited no more than once.
     * @param A
     * @return
     */
    public int jump(int[] A) {
        if(A.length==1)
            return A[0]>=0? 0: -1;
        int f = A[0];
        int l = 1;
        int r = f;
        int cnt = 1;
        while(f<A.length-1) {
            for(int i=l; i<=r; i++)
                f = Math.max(f, A[i]+i);
            if(f<=r)
                return -1;
            l = r+1;
            r = f;
            cnt++;
        }
        return cnt;
    }

    public static void main(String[] args) {
        int ret = new Solution().jump(new int[]{2, 3, 1, 1, 4});
        assert ret==2;
    }
}