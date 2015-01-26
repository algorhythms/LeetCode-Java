package RemoveDuplicatesfromSortedArrayII;

/**
 * User: Danyang
 * Date: 1/26/2015
 * Time: 12:18
 *
 * Follow up for "Remove Duplicates":
 What if duplicates are allowed at most twice?

 For example,
 Given sorted array A = [1,1,1,2,2,3],

 Your function should return length = 5, and A is now [1,1,2,2,3].
 */
public class Solution {
    public int removeDuplicates_error(int[] A) {
        if(A.length==0)
            return 0;
        int i = 0;
        int j = 1;
        int allowed = 1;
        for(; i<A.length; i++, j++) {
            while(j<A.length && A[j]==A[i]) {
                allowed--;
                j++;
            }
            if(allowed==0)
                A[i+1] = A[j-1];

            if(allowed<1)
                i++;

            if(j==A.length)
                break;
            A[i+1] = A[j];
            allowed = 1;
        }
        return i+1;
    }

    public int removeDuplicates(int [] A) {
        if(A.length==0)
            return 0;
        int i = 0;
        int j = 1;
        boolean repeated = false;
        while(j<A.length) {  // one loop would be clear
            if(A[i]==A[j] &&!repeated) { // duplicated but not repeated
                repeated = true;
                A[i+1] = A[j];
                j++;
                i++;
            }
            else if(A[i]==A[j] && repeated) { // duplicated and repeated
                j++;
            }
            else {  // not duplicated
                repeated = false;
                A[i+1] = A[j];
                i++;
                j++;
            }
        }
        return i+1;
    }
}