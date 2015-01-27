package RecoverBinarySearchTree;

import commons.datastructures.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * User: Danyang
 * Date: 1/27/2015
 * Time: 21:30
 *
 * Two elements of a binary search tree (BST) are swapped by mistake.

 Recover the tree without changing its structure.

 Note:
 A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?

 */
public class Solution {
    List<TreeNode> pair = new ArrayList<>();  // O(2)
    TreeNode cur;
    TreeNode pre;
    /**
     * Flatten to In-order array to do the analysis
     * Global pointers
     * Notice:
     * 1. pointers
     * 2. case when the 2 swapped are neighbor in in-order array
     * 3. case when the 2 swapped are not neighbor in in-order array
     * @param root
     */
    public void recoverTree(TreeNode root) {
        inorder(root);
        assert pair.size()==2;
        int t = pair.get(0).val;
        pair.get(0).val = pair.get(1).val;
        pair.get(1).val = t;
    }

    void inorder(TreeNode c) {
        if(c==null)
            return ;
        inorder(c.left);
        pre = cur;
        cur = c;
        if(pre != null) {
            if(pre.val>cur.val) {
                if(pair.size()==0) {
                    pair.add(pre);
                    pair.add(cur);
                }
                else {
                    pair.remove(pair.size()-1);
                    pair.add(cur);
                }
                assert pair.size()==2;
            }
        }
        inorder(c.right);
    }
}