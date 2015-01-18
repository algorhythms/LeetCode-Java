package DivideTwoIntegers;

/**
 * User: Danyang
 * Date: 1/18/2015
 * Time: 11:00
 *
 * Divide two integers without using multiplication, division and mod operator.

 If it is overflow, return MAX_INT.
 */
public class Solution {
    /**
     * Naive Algorithm: brute force subtraction
     * Algorithm: subtraction with power of 2
     *
     * Notice:
     * 1. Overflow may happen in Java: -1010369383, -2147483648
     * 2. MIN_VALUE = -2147483648
     *    MAX_VALUE = 2147483647
     *
     * @param dividend
     * @param divisor
     * @return
     */
    public int divide(int dividend, int divisor) {
        int sign = -1;
        if(dividend==0)
            return 0;
        if(divisor==0)
            return Integer.MAX_VALUE;
        if(dividend>0 && divisor>0 || dividend<0 && divisor<0)
            sign = 1;

        // handle overflow
        if(divisor==1)
            return dividend;
        if(divisor==-1)
            if(dividend==Integer.MIN_VALUE)
                return Integer.MAX_VALUE;
            else
                return dividend*-1;

        if(dividend==Integer.MIN_VALUE){
            if(divisor < 0)
                return divide(dividend-divisor, divisor)+1;
            else
                return divide(dividend+divisor, divisor)-1;
        }

        if(divisor==Integer.MIN_VALUE){
            return dividend==divisor? 1: 0;
        }

        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);


        // main algorithm
        int ret = 0;
        while(divisor<=dividend) { // changing dividend
            int cur_divisor = divisor;
            int cur_ret = 1;
            while(cur_divisor<=dividend/2) {
                cur_divisor <<= 1;
                cur_ret <<= 1;
            }
            dividend -= cur_divisor;
            ret += cur_ret;
        }
        return ret*sign;
    }

    public static void main(String[] args) {
        int ret = new Solution().divide(-2147483648, -1);
        System.out.println(ret);
    }
}