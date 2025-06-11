package org.hireme.neetcode.graph;

import java.util.*;

public class Clone_Graph {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        Node root = new Node(node.val);

        return dfs(node, root, new HashMap<>());


    }

    public Node dfs(Node node, Node copy, HashMap<Integer, Node> visitedMap) {
        visitedMap.put(node.val, copy);

        List<Node> neighbours = node.neighbors;

        for (Node neighbour : neighbours) {
            if (!visitedMap.containsKey(neighbour.val)) {
                copy.neighbors.add(dfs(neighbour, new Node(neighbour.val), visitedMap));
            } else {
                copy.neighbors.add(visitedMap.get(neighbour.val));
            }
        }


        return copy;
    }

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
}
