package commons.datastructures;

/**
 * User: Danyang
 * Date: 1/17/2015
 * Time: 21:03
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                '}';
    }
}