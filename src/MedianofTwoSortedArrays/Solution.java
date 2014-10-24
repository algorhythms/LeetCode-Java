package MedianofTwoSortedArrays;

import java.util.Arrays;

/**
 * “Measuring programming progress by lines of code is like measuring aircraft building progress by weight.”
 * - Bill Gates
 * User: Danyang
 * Date: 10/21/14
 * Time: 10:45 PM
 */
public class Solution {
    public double findMedianSortedArrays(int A[], int B[]) {
        int m = A.length;
        int n = B.length;
        if((m+n)%2==1) {
            return this.findKth(A, B, (m+n)/2);
        }
        else {
            return 0.5*(this.findKth(A, B, (m+n)/2)+findKth(A, B, (m+n)/2-1));
        }
    }

    private double findKth(int A[], int B[], int k) {
        int m = A.length;
        int n = B.length;
        if(m<=0) return B[k];
        if(n<=0) return A[k];
        if(k==0) return Math.min(A[0], B[0]);
        if(A[m/2]>B[n/2]) {
            // if(k>(m+n)/2)
            if(k>m/2+n/2)
                return this.findKth(A, Arrays.copyOfRange(B, n/2+1, n), k-n/2-1);
            else
                return this.findKth(Arrays.copyOfRange(A, 0, m/2), B, k);
        }
        else {
            // if(k>(m+n)/2)
            if(k>m/2+n/2)
                return this.findKth(Arrays.copyOfRange(A, m/2+1, m), B, k-m/2-1);
            else
                return this.findKth(A, Arrays.copyOfRange(B, 0, n/2), k);
        }
    }

    public static void main(String[] args) {
        int [] A = {1};
        int [] B = {1};
        System.out.println(new Solution().findMedianSortedArrays(A, B));
    }
}