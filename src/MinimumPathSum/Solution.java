package MinimumPathSum;

/**
 * User: Danyang
 * Date: 1/20/2015
 * Time: 10:51
 *
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the
 * sum of all numbers along its path.

 Note: You can only move either down or right at any point in time.
 */
public class Solution {
    /**
     * f[i][j] represents the min path to i, j
     * f[i][j] = min(f[i-1][j], f[i][j-1])+grid[i][j]
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        if(m==0)
            return 0;
        int n = grid[0].length;
        if(n==0)
            return 0;

        int[][] f = new int[m+1][n+1];
        // initialize
        for(int i=0; i<m+1; i++)
            for(int j=0; j<n+1; j++)
                f[i][j] = Integer.MAX_VALUE;
        f[0][1] = 0;  // entry


        for(int i=1; i<m+1; i++)
            for(int j=1; j<n+1; j++)
                f[i][j] = Math.min(f[i-1][j], f[i][j-1])+grid[i-1][j-1];
        return f[m][n];
    }
}