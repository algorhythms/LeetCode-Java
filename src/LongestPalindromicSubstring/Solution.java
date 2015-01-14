package LongestPalindromicSubstring;

/**
 * User: Danyang
 * Date: 1/14/2015
 * Time: 22:04
 *
 * Given a string S, find the longest palindromic substring in S. You may assume that the maximum length of S is 1000,
 * and there exists one unique longest palindromic substring.
 */
public class Solution {
    /**
     * DP
     * f[i][j] in s[i..j] the longest Palindrome // not working
     * f[i][j] is whether s[i..j] is palindrome
     * f[i][j] = s[i]==s[j-1] and f[i+1][j-1]
     *
     * O(n^2)
     *
     * Manacher’s Algorithm O(n)
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean [][] f = new boolean[n+1][n+1];
        int ml = 0, r = 0, l = 0;
        for(int j=1; j<n+1; j++) {
            for(int i=0; i<j; i++ ) {
                f[i][j] = s.charAt(i)==s.charAt(j-1) && (i+1>=j-1 || f[i+1][j-1]); // notice the loop order  // notice the boolean short-circuiting
                if(f[i][j] && ml<j-i) {
                    ml = j-i;
                    l = i;
                    r = j;
                }
            }
        }
        return s.substring(l, r);
    }
}