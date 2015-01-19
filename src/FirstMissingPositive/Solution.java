package FirstMissingPositive;

/**
 * User: Danyang
 * Date: 1/19/2015
 * Time: 11:21
 * Given an unsorted integer array, find the first missing positive integer.

 For example,
 Given [1,2,0] return 3,
 and [3,4,-1,1] return 2.

 Your algorithm should run in O(n) time and uses constant space.
 */
public class Solution {
    /**
     * Without additional space
     * 0 does not count
     *
     * Notice:
     * 1. duplicate
     *
     * Test cases:
     * 0. []
     * 1. [1, 1]
     * @param A
     * @return
     */
    public int firstMissingPositive(int[] A) {
        for(int i=0; i<A.length; ) {
            int pos = A[i] - 1;
            if(pos>=0 && pos<A.length && i!=pos && A[pos]!=pos+1) {
                int t = A[i]; A[i] = A[pos]; A[pos] = t;
            }
            else {
                i++;
            }
        }

        for(int i=0; i<A.length; i++) {
            if(A[i]!=i+1)
                return i+1;
        }
        return A.length+1;
    }
}