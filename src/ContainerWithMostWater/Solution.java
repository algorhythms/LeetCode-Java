package ContainerWithMostWater;

/**
 * User: Danyang
 * Date: 1/17/2015
 * Time: 12:54
 *
 * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines
 * are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis
 * forms a container, such that the container contains the most water.
 *
    Note: You may not slant the container.
 */
public class Solution {
    /**
     * Two pointers
     * O(N)
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int maxa = 0;
        int l = 0;
        int r = height.length-1;
        while(l<r) {
            maxa = Math.max(maxa,
                    (r-l)*Math.min(height[r], height[l])
            );
            if(height[r]>height[l])
                l++;
            else
                r--;
        }
        return maxa;
    }
}