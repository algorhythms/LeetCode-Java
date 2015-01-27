package commons.datastructures;

import java.util.ArrayList;
import java.util.List;

/**
 * User: Danyang
 * Date: 1/27/2015
 * Time: 23:53
 */
public class UndirectedGraphNode {
    public int label;
    public List<UndirectedGraphNode> neighbors;
    public  UndirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<UndirectedGraphNode>();
    }
}
