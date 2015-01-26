package EditDistance;

/**
 * User: Danyang
 * Date: 1/26/2015
 * Time: 11:09
 *
 * Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation
 * is counted as 1 step.)

 You have the following 3 operations permitted on a word:

 a) Insert a character
 b) Delete a character
 c) Replace a character
 */
public class Solution {
    /**
     * from word1 to word2
     * f[i, j] the min distance from word1[0..i] tp word2[0..j]
     * if word1[i]==word2[j]:
     * f[i][j] = f[i-1][j-1]
     *
     * else:
     * delete: f[i, j] = f[i-1, j]+1
     * insert: f[i, j] = f[i, j-1]+1
     * replace f[i, j] = f[i-1, j-1]+1
     *
     * Notice:
     * 1. the INITIAL condition
     *
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] f = new int[m+1][n+1];
        for(int j=0; j<n+1; j++)
            f[0][j] = j;
        for(int i=0; i<m+1; i++)
            f[i][0] = i;

        for(int i=1; i<m+1; i++)
            for(int j=1; j<n+1; j++) {
                if(word1.charAt(i-1)==word2.charAt(j-1))
                    f[i][j] = f[i-1][j-1];
                else {
                    f[i][j] = Math.min(f[i-1][j]+1, Math.min(f[i][j-1]+1, f[i-1][j-1]+1));
                }
            }
        return f[m][n];
    }
}