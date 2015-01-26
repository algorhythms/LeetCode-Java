package RemoveElement;

/**
 * User: Danyang
 * Date: 1/26/2015
 * Time: 10:58
 *
 * Given an array and a value, remove all instances of that value in place and return the new length.

 The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 */
public class Solution {
    /**
     * Put it to back
     * @param A
     * @param elem
     * @return
     */
    public int removeElement(int[] A, int elem) {
        int e = A.length-1;
        for(int i=0; i<=e; ) {
            if(A[i]!=elem)
                i++;
            else {
                int t = A[i]; A[i] = A[e]; A[e] = t;
                e--;
            }
        }
        return e+1;
    }
}