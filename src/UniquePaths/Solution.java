package UniquePaths;

/**
 * User: Danyang
 * Date: 1/19/2015
 * Time: 20:29
 *  robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

 The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner
 of the grid (marked 'Finish' in the diagram below).

 How many possible unique paths are there?
 */
public class Solution {
    /**
     * DP
     * f[i][j] = f[i-1][j] + f[i][j-1]
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        int [][] f = new int[m+1][n+1];
        f[0][1] = 1;
        for(int i=1; i<m+1; i++)
            for(int j=1; j<n+1; j++)
                f[i][j] = f[i-1][j]+f[i][j-1];

        return f[m][n];
    }
}