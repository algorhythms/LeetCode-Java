package Triangle;

import java.util.List;
import java.util.stream.Collectors;

/**
 * User: Danyang
 * Date: 1/26/2015
 * Time: 23:52
 *
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row
 * below.

 For example, given the following triangle
 [
 [2],
 [3,4],
 [6,5,7],
 [4,1,8,3]
 ]
 The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

 Note:
 Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
 */
public class Solution {
    /**
     * dp
     * let f[i][j] represent the minimal path sum from bottom to i, j
     * f[i][j] = min(f[i+1][j], f[i+1][j+1])+t[i][j]
     * @param triangle
     * @return
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        List<List<Integer>> f = triangle.stream()
                .map(e -> e.stream().map(e2->0).collect(Collectors.toList()))
                .collect(Collectors.toList());
        for(int i=0; i<triangle.get(triangle.size()-1).size(); i++) {
            f.get(f.size()-1).set(i, triangle.get(triangle.size()-1).get(i));
        }
        for(int i=triangle.size()-2; i>-1; i--) {
            for(int j=0; j<triangle.get(i).size(); j++) {
                int min = Math.min(f.get(i+1).get(j), f.get(i+1).get(j+1))+triangle.get(i).get(j);
                f.get(i).set(j, min);
            }
        }
        return f.get(0).get(0);
    }
}