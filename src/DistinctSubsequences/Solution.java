package DistinctSubsequences;

/**
 * User: Danyang
 * Date: 1/28/2015
 * Time: 18:46
 *
 * Given a string S and a string T, count the number of distinct subsequences of T in S.

 A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of
 the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of
 "ABCDE" while "AEC" is not).

 Here is an example:
 S = "rabbbit", T = "rabbit"

 Return 3.
 */
public class Solution {
    /**
     * let f[i][j] represents the num of distinct subsequence of b[0..j] in a[0..i]
     * f[i][j] = f[i-1][j-1] + f[i-1][j] if a[i]=b[i]
     *         = f[i-1][j] otherwise
     * @param S
     * @param T
     * @return
     */
    public int numDistinct(String S, String T) {
        int m = S.length();
        int n = T.length();
        int[][] f = new int[m+1][n+1];
        for(int i=0; i<m+1; i++)
            f[i][0] = 1;
        for(int i=1; i<m+1; i++) {
            for(int j=1; j<n+1; j++) {
                if(S.charAt(i-1)==T.charAt(j-1))
                    f[i][j] = f[i-1][j-1];
                f[i][j] += f[i-1][j];
            }
        }
        return f[m][n];
    }
}