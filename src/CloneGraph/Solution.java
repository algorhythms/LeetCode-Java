package CloneGraph;

import commons.datastructures.UndirectedGraphNode;

import java.util.HashMap;
import java.util.Map;

/**
 * User: Danyang
 * Date: 1/27/2015
 * Time: 23:55
 * Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node==null)
            return null;
        Map<UndirectedGraphNode, UndirectedGraphNode> cloned = new HashMap<>();
        dfs(node, cloned);
        return cloned.get(node);
    }

    void dfs(UndirectedGraphNode node, Map<UndirectedGraphNode, UndirectedGraphNode> cloned) {
        UndirectedGraphNode clone = new UndirectedGraphNode(node.label);
        cloned.put(node, clone);
        for(UndirectedGraphNode neighbor: node.neighbors) {
            if(!cloned.containsKey(neighbor))
                dfs(neighbor, cloned);
            clone.neighbors.add(cloned.get(neighbor));
        }
    }
}