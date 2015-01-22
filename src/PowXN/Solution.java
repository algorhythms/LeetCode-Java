package PowXN;

/**
 * User: Danyang
 * Date: 1/22/2015
 * Time: 20:11
 *
 * Implement pow(x, n).
 */
public class Solution {
    /**
     * classical quick power algorithm
     * Notice
     * 1. walk through the steps of algorithm
     * 2. x<0 case, n<0 case
     * @param x
     * @param n
     * @return
     */
    public double pow(double x, int n) {
        if(n==0)
            return 1;

        int sign = x>0 || (n&1)==0 ? 1: -1;  // common bugs
        boolean inverted = n <= 0;
        x = Math.abs(x);
        n = Math.abs(n);


        double ret = 1;
        double fac = x;
        while(n>1) {
            if((n&1)==1)
                ret *= fac;
            fac *= fac;
            n /= 2;
        }
        ret *= fac;
        ret *= sign;
        if(inverted)
            ret = 1/ret;
        return ret;
    }
}