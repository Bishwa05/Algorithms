package dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CloneGraph {
    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public Node cloneGraph(Node node) {
        if(node == null) return null;
        Map<Integer,Node> nodeMap = new HashMap<>();
        return cloneGraph(node, nodeMap);
    }

    private Node cloneGraph(Node node, Map<Integer, Node> nodeMap) {
        if(nodeMap.containsKey(node.val)) return nodeMap.get(node.val);
        Node clonedNode = new Node(node.val);
        nodeMap.put(node.val,clonedNode);

        for(Node neighbour: node.neighbors){
            clonedNode.neighbors.add(cloneGraph(neighbour, nodeMap));
        }
        return clonedNode;
    }

    public static void main(String arg[]){

    }

}
