package UniquePathsII;

/**
 * User: Danyang
 * Date: 1/19/2015
 * Time: 20:35
 *
 * Follow up for "Unique Paths":

 Now consider if some obstacles are added to the grids. How many unique paths would there be?

 An obstacle and empty space is marked as 1 and 0 respectively in the grid.

 For example,
 There is one obstacle in the middle of a 3x3 grid as illustrated below.

 [
 [0,0,0],
 [0,1,0],
 [0,0,0]
 ]
 The total number of unique paths is 2.

 Note: m and n will be at most 100.
 */
public class Solution {
    /**
     * f[i][j] = f[i-1][j] + f[i][j-1] if possible
     * Notice:
     * 1. boundary case
     * 2. it itself is obstacle
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        if(m==0)
            return 0;
        int n = obstacleGrid[0].length;
        if(n==0)
            return 0;

        int[][] f = new int[m+1][n+1];
        f[0][1] = 1;
        for(int i=1; i<m+1; i++)
            for(int j=1; j<n+1; j++) {
                if(i-2<0 || obstacleGrid[i-2][j-1]==0)
                    f[i][j] += f[i-1][j];
                if(j-2<0 || obstacleGrid[i-1][j-2]==0)
                    f[i][j] += f[i][j-1];
                if(obstacleGrid[i-1][j-1]==1)
                    f[i][j] = 0;
            }
        return f[m][n];
    }
}