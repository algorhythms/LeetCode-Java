package UniqueBinarySearchTrees;

/**
 * User: Danyang
 * Date: 1/27/2015
 * Time: 15:40
 *
 * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

 For example,
 Given n = 3, there are a total of 5 unique BST's.

 1         3     3      2      1
 \       /     /      / \      \
 3     2     1      1   3      2
 /     /       \                 \
 2     1         2                 3
 */
public class Solution {
    /**
     * Catalan Number
     * C_0 = 1
     * C_{n+1} = \sum_{i=0}^n C_i * C_{n-i}
     * @param n
     * @return
     */
    public int numTrees(int n) {
        return dfs(n);
    }

    int dfs(int n) {
        if(n<=1)
            return 1;
        int sum = 0;
        for(int i=0; i<n; i++) {
            sum += dfs(i)*dfs(n-1-i);
        }
        return sum;
    }

    public static void main(String[] args) {
        int ret = new Solution().numTrees(3);
        System.out.println(ret);
    }
}