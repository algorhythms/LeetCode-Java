package ValidPalindrome;

/**
 * User: Danyang
 * Date: 1/28/2015
 * Time: 10:46
 *
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

 For example,
 "A man, a plan, a canal: Panama" is a palindrome.
 "race a car" is not a palindrome.

 Note:
 Have you consider that the string might be empty? This is a good question to ask during an interview.

 For the purpose of this problem, we define empty string as valid palindrome.
 */
public class Solution {
    public boolean isPalindrome(String s) {
        int[] cs = s.toLowerCase().chars().filter(e -> e>='a' && e<='z' || e>='0' && e<='9').toArray();
        for(int i=0; i<cs.length/2; i++)
            if(cs[i]!=cs[cs.length-1-i])
                return false;
        return true;
    }
}