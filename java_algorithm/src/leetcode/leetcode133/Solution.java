package leetcode.leetcode133;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    static boolean[] visited;
    public Node cloneGraph(Node node) {
        if(node == null) {
            return null;
        }
        Map<Node, Node> map = new HashMap<>();
        return dfs(node, map);
    }

    static Node dfs(Node current, Map<Node, Node> map) {
        if (map.containsKey(current)) {
            return map.get(current);
        }

        Node cloneNode = new Node(current.val);
        map.put(current, cloneNode);

        for (Node neighbor : current.neighbors) {
            cloneNode.neighbors.add(dfs(neighbor, map));
        }

        return cloneNode;
    }

    static class Node {
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

}