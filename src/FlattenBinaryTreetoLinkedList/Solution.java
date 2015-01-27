package FlattenBinaryTreetoLinkedList;

import commons.datastructures.TreeNode;

/**
 * User: Danyang
 * Date: 1/27/2015
 * Time: 17:17
 *
 * Given a binary tree, flatten it to a linked list in-place.
 */
public class Solution {
    private TreeNode ptr;

    /**
     * Using a global pointer to keep the last in a subList
     * Notice:
     * 1. need to update ptr
     * 2. gonna loop anyway, easier to write a getLast() function.
     * @param root
     */
    public void flatten(TreeNode root) {
        getFlattened(root);
    }

    TreeNode getFlattened(TreeNode cur) {
        if(cur==null)
            return null;

        ptr = cur;
        TreeNode r = getFlattened(cur.right);
        TreeNode l = getFlattened(cur.left);
        if(l==null)
            cur.right = r;
        else {
            ptr.right = r;
            // need to update ptr
            while(ptr.right!=null)
                ptr = ptr.right;
            cur.left = null;
            cur.right = l;
        }
        return cur;
    }
}