package MaximumSubarray;

/**
 * User: Danyang
 * Date: 1/22/2015
 * Time: 20:49
 *
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

 For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
 the contiguous subarray [4,−1,2,1] has the largest sum = 6.

 More practice:
 If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.

 */
public class Solution {
    /**
     * O(n) iterative is trivial
     * Divide and Conquer Approach
     * O(n lgn)
     * 1. divide in half
     * 2. left max sub
     * 3. right max sub
     * 4. max sub crossing the middle point
     * @param A
     * @return
     */
    public int maxSubArray(int[] A) {
        return maxSubArray(A, 0, A.length);
    }

    int maxSubArray(int[] A, int s, int e) {
        if(s>=e)
            return Integer.MIN_VALUE;
        if(s==e-1)
            return A[s];

        int m = (s+e)/2;
        int l = maxSubArray(A, s, m);
        int r = maxSubArray(A, m, e);
        int c = maxCross(A, s, e, m);
        return Math.max(Math.max(l, r), c);
    }

    int maxCross(int[] A, int s, int e, int m) {
        int max_l = A[m];
        int max_r = A[m];

        int acc = A[m];
        for(int i=m-1; i>=s; i--) {
            acc += A[i];
            max_l = Math.max(max_l, acc);
        }
        acc = A[m];
        for(int i=m+1; i<e; i++) {
            acc += A[i];
            max_r = Math.max(max_r, acc);
        }
        return max_l+max_r-A[m];
    }
}