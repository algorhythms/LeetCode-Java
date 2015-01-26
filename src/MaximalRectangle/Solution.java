package MaximalRectangle;

/**
 * User: Danyang
 * Date: 1/26/2015
 * Time: 15:33
 *
 * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing all ones and return its area.
 */
public class Solution {
    /**
     * Brute force O(n^2)*O(n^2)
     * Beyond brute force: O(n^2)*O(2n)
     *
     * v[i][j] vertical # continuous 1, upside
     * h[i][j] horizontal # continuous 1, left-side
     *
     * Notice:
     * 1. i, j, l, k
     * @param matrix
     * @return
     */
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        if(m==0)
            return 0;
        int n = matrix[0].length;
        if(n==0)
            return 0;
        int[][] vertical = new int[m+1][n+1];
        int[][] horizontal = new int[m+1][n+1];
        for(int i=1; i<m+1; i++)
            for(int j=1; j<n+1; j++) {
                if(matrix[i-1][j-1]=='0') {
                    vertical[i][j] = 0;
                    horizontal[i][j] = 0;
                }
                else {
                    vertical[i][j] = vertical[i-1][j]+1;
                    horizontal[i][j] = horizontal[i][j-1]+1;
                }
            }

        int maxa = 0;
        for(int i=0; i<m; i++)
            for(int j=0; j<n; j++) {
                int height = Integer.MAX_VALUE;
                for(int l=j; l>j-horizontal[i+1][j+1]; l--) {
                    height = Math.min(height, vertical[i+1][l+1]);
                    maxa = Math.max(maxa, height*(j-l+1));
                }
            }
        return maxa;
    }

    public int maximalRectangle_error(char[][] matrix) {
        int m = matrix.length;
        if(m==0)
            return 0;
        int n = matrix[0].length;
        if(n==0)
            return 0;
        int[][] vertical = new int[m+1][n+1];
        int[][] horizontal = new int[m+1][n+1];
        for(int i=1; i<m+1; i++)
            for(int j=1; j<n+1; j++) {
                if(matrix[i-1][j-1]=='0') {
                    vertical[i][j] = 0;
                    horizontal[i][j] = 0;
                }
                else {
                    vertical[i][j] = vertical[i-1][j]+1;
                    horizontal[i][j] = horizontal[i][j-1]+1;
                }
            }

        int maxa = 0;
        for(int i=0; i<m; i++)
            for(int j=0; j<n; j++) {
                int height = vertical[i+1][j+1];
                int length = horizontal[i+1][j+1];
                for(int l=j; l>j-horizontal[i+1][j+1]; l--)
                    height = Math.min(height, vertical[i+1][l+1]);
                for(int k=i; k>i-vertical[i+1][j+1]; k--)
                    length = Math.min(length, horizontal[k+1][j+1]);
                maxa = Math.max(maxa, Math.max(horizontal[i+1][j+1]*height, vertical[i+1][j+1]*length));  // logic flaw
            }

        return maxa;
    }

    public static void main(String[] args) {
        int ret = new Solution().maximalRectangle(new char[][] {
                {'1', '1', '0', '1'},
                {'1', '1', '0', '1'},
                {'1', '1', '1', '1'},

        });
        assert ret==6;
    }
}