package RemoveDuplicatesfromSortedArray;

/**
 * User: Danyang
 * Date: 1/26/2015
 * Time: 11:55
 *
 * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new
 * length.

 Do not allocate extra space for another array, you must do this in place with constant memory.

 For example,
 Given input array A = [1,1,2],

 Your function should return length = 2, and A is now [1,2].
 */
public class Solution {
    /**
     * Two Pointers
     * @param A
     * @return
     */
    public int removeDuplicates(int[] A) {
        if(A.length==0)
            return 0;
        int i = 0;
        int j = 1;
        for(; i<A.length; i++) {
            while(j<A.length && A[j]==A[i]) j++;
            if(j==A.length) break;
            A[i+1] = A[j];
        }
        return i+1;
    }
}