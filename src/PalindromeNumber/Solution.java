package PalindromeNumber;

/**
 * User: Danyang
 * Date: 1/15/2015
 * Time: 12:44
 * Determine whether an integer is a palindrome. Do this without extra space.
 */
public class Solution {
    /**
     * TESTING
     * OVERFLOW
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {
        if(x<0)
            return false;
        long sig = 1;  // int overflow
        for(int i=x; i>0; i/=10)
            sig *= 10;
        sig /= 10;

//        for(int i=x; i>=10; i=i%(sig)/10, sig/=100) {
//            if(i%10!=i/sig)
//                return false;
//        }
        int acc = 10;
        for(int i=x; sig>=acc; sig/=10, acc*=10) {
            long l = i/sig%10;
            long r = i%acc/(acc/10);
            if(r!=l)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isPalindrome(1000000001));
        System.out.println(new Solution().isPalindrome(100031));
        System.out.println(new Solution().isPalindrome(12321));
    }
}