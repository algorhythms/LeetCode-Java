package ReverseInteger;

/**
 * User: Danyang
 * Date: 1/15/2015
 * Time: 12:17
 * Reverse digits of an integer.
     Example1: x = 123, return 321
     Example2: x = -123, return -321
 */
public class Solution {
    /**
     * OVERFLOW
     * @param x
     * @return
     */
    public int reverse(int x) {
        int sign = x>0? 1: -1;
        x *= sign;
        int ret = 0;
        while(x>0) {
            ret *= 10;
            if(ret<0 || x>10&&ret*10/10!=ret) // overflow
                return 0;

            ret += x%10;
            x /= 10;
        }
        return ret*sign;
    }

    public static void main(String[] args) {
        assert new Solution().reverse(-2147483412)==-2147483412;
    }
}