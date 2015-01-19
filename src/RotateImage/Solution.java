package RotateImage;

/**
 * User: Danyang
 * Date: 1/19/2015
 * Time: 11:08
 * You are given an n x n 2D matrix representing an image.

 Rotate the image by 90 degrees (clockwise).
 */
public class Solution {
    /**
     * Drawing
     * flip horizontally
     * fli diagonally (left top to bottom right)
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        int m = matrix.length;
        if(m<=0)
            return ;
        int n = matrix[0].length;
        if(n<=0 || n!=m)
            return ;

        for(int i=0; i<n/2; i++)
            for(int j=0; j<n; j++) {
                int t = matrix[i][j];
                matrix[i][j] = matrix[n-1-i][j];
                matrix[n-1-i][j] = t;
            }

        for(int i=0; i<n; i++)
            for(int j=0; j<i; j++) {
                int t = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = t;
            }

    }
}