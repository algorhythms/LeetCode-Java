package LengthofLastWord;

/**
 * User: Danyang
 * Date: 1/19/2015
 * Time: 11:00
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last
 * word in the string.

 If the last word does not exist, return 0.

 Note: A word is defined as a character sequence consists of non-space characters only.
 */
public class Solution {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        String [] ss = s.split(" ");
        if(ss.length<=0)
            return 0;
        return ss[ss.length-1].length();
    }
}