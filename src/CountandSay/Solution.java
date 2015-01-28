package CountandSay;

/**
 * User: Danyang
 * Date: 1/28/2015
 * Time: 10:37
 *
 * The count-and-say sequence is the sequence of integers beginning as follows:
 1, 11, 21, 1211, 111221, ...

 1 is read off as "one 1" or 11.
 11 is read off as "two 1s" or 21.
 21 is read off as "one 2, then one 1" or 1211.
 Given an integer n, generate the nth sequence.

 Note: The sequence of integers will be represented as a string.
 */
public class Solution {
    public String countAndSay(int n) {
        String ret = "1";
        for(int i=0; i<n-1; i++)
            ret = trans(ret);
        return  ret;
    }

    /**
     * Two pointers
     * Notice:
     * 1. initial condition of j
     * @param s
     * @return
     */
    String trans(String s) {
        StringBuilder sb = new StringBuilder();
        char[] cs = s.toCharArray();
        int i = 0;
        int j = 0;
        while(i<cs.length && j<cs.length) {
            for(; j<cs.length && cs[i]==cs[j]; j++);
            sb.append(j-i).append(cs[i]);
            i = j;
        }
        return sb.toString();
    }
}