package ConvertSortedArraytoBinarySearchTree;

import commons.datastructures.TreeNode;

/**
 * User: Danyang
 * Date: 1/27/2015
 * Time: 16:46
 *
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 */
public class Solution {
    public TreeNode sortedArrayToBST(int[] num) {
        return toBST(num, 0, num.length);
    }

    TreeNode toBST(int[] num, int s, int e) {
        if(s>=e)
            return  null;
        int m = (s+e)/2;
        TreeNode cur = new TreeNode(num[m]);
        TreeNode l = toBST(num, s, m);
        TreeNode r = toBST(num, m+1, e);
        cur.left = l;
        cur.right = r;
        return cur;
    }
}