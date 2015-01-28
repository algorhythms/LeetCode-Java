package InterleavingString;

/**
 * User: Danyang
 * Date: 1/28/2015
 * Time: 17:11
 *
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.

 For example,
 Given:
 s1 = "aabcc",
 s2 = "dbbca",

 When s3 = "aadbbcbcac", return true.
 When s3 = "aadbbbaccc", return false.
 */
public class Solution {
    /**
     * dp
     * f[i, j] represents s3[0..i+j] is interleaved from s1[0..i] and s2[0..j]
     * f[i, j] = f[i-1, j] if s1[i] = s3[i+j]
     *         = f[i, j-1] if s2[j] = s3[i+j]
     *
     * Notice:
     * 1. initial condition
     * 2. s3[i+j-1] rather than s3[i+j-2]
     * @param s1
     * @param s2
     * @param s3
     * @return
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length()+s2.length()!=s3.length())
            return false;

        boolean[][] f = new boolean[s1.length()+1][s2.length()+1];
        f[0][0] = true;
        for(int i=1; i<s1.length()+1; i++)
            f[i][0] = f[i-1][0] && s1.charAt(i-1)==s3.charAt(i-1);
        for(int j=1; j<s2.length()+1; j++)
            f[0][j] = f[0][j-1] && s2.charAt(j-1)==s3.charAt(j-1);

        for(int i=1; i<s1.length()+1; i++)
            for(int j=1; j<s2.length()+1; j++) {
                if(!f[i][j] && s1.charAt(i-1)==s3.charAt(i+j-1))
                    f[i][j] = f[i-1][j];
                if(!f[i][j] && s2.charAt(j-1)==s3.charAt(i+j-1))
                    f[i][j] = f[i][j-1];
            }

        return f[s1.length()][s2.length()];
    }

    public static void main(String[] args) {
        assert new Solution().isInterleave("aabcc", "dbbca", "aadbbcbcac");
    }
}