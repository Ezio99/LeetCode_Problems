package org.hireme.datastructure.graph;

import java.util.*;

public class Graph {

    static class Node {
        int vertex;
        int cost;

        public Node(int vertex, int cost) {
            this.vertex = vertex;
            this.cost = cost;
        }

        public int compareTo(Node otherNode) {
            return Integer.compare(this.cost, otherNode.cost);
        }
    }

    HashMap<Integer, List<Node>> graph;
    int n;

    public Graph(int n) {
        graph = new HashMap<>();
        this.n = n;
    }

    public void addEdge(int u, int v, int w) {
        graph.computeIfAbsent(u, k -> new ArrayList<>()).add(new Node(v, w));
        //Add to destination if bidirectional
    }

    public int[] dijkstra(int source) {
        int[] dist = new int[n];

        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[source] = 0;

        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.compareTo(o2);
            }
        });

        //Starting from source so cost 0
        priorityQueue.add(new Node(source, 0));

        while (!priorityQueue.isEmpty()) {
            Node currentNode = priorityQueue.poll();

            //We dont need visited check, actually we dont even need to check if our current path to node is smaller or not
            //Remember dijkstra is a greedy algorithm if we have visited the node once, any further time we visit the node
            // the path to it will be longer than what we already have
            //All we need to check is if the dist is Integer.MAX_VALUE or not, if it is Integer.MAX_VALUE we process it
            // If its not Integer.MAX_VALUE, we are already guaranteed the pre-existing path to this node is smaller than what
            // we are processing now
//            if (visited[currentNode.vertex]) {
//                continue;
//            }
//            visited[currentNode.vertex] = true;

            if (currentNode.cost > dist[currentNode.vertex]) {
                continue;
            }

            if (graph.get(currentNode.vertex) == null) {
                continue;
            }

            for (Node neigbhour : graph.get(currentNode.vertex)) {
                int newDist = dist[currentNode.vertex] + neigbhour.cost;
                if (newDist < dist[neigbhour.vertex]) {
                    //since it is greedy and we find the current path to a neighbour is the shortest, we can immediately update the dist to it
                    // so that in the future if we are processing some other node which also has a path to that node
                    // we dont add it to the PQ because its guaranteed to be longer anyway
                    dist[neigbhour.vertex] = newDist;
                    priorityQueue.add(new Node(neigbhour.vertex, newDist));
                }
            }
        }

        return dist;
    }


    public static void main(String[] args) {
        testBasicGraph();
        testDisconnectedGraph();
        testCycleGraph();
        testSingleNodeGraph();
        testMultiplePathsSameLength();
        testLargeDenseGraph();
        testLargeSparseGraph();
    }

    public static void testBasicGraph() {
        Graph graph = new Graph(4); // Create a graph with 4 vertices (A, B, C, D)
        graph.addEdge(0, 1, 1); // A-B: 1
        graph.addEdge(0, 2, 4); // A-C: 4
        graph.addEdge(1, 2, 2); // B-C: 2
        graph.addEdge(1, 3, 3); // B-D: 3
        graph.addEdge(2, 3, 1); // C-D: 1

        int[] distances = graph.dijkstra(0); // Start from vertex A (index 0)

        System.out.println("Basic Test Case");
//        checkResult("A", distances[0], 0);
        checkResult("B", distances[1], 1);
        checkResult("C", distances[2], 3);
        checkResult("D", distances[3], 4);
    }

    public static void testDisconnectedGraph() {
        Graph graph = new Graph(4); // Create a graph with 4 vertices (A, B, C, D)
        graph.addEdge(0, 1, 3); // A-B: 3
        graph.addEdge(2, 3, 2); // C-D: 2

        int[] distances = graph.dijkstra(0); // Start from vertex A (index 0)

        System.out.println("Disconnected Nodes Test Case");
        checkResult("A", distances[0], 0);
        checkResult("B", distances[1], 3);
        checkResult("C", distances[2], Integer.MAX_VALUE); // ∞ (Unreachable)
        checkResult("D", distances[3], Integer.MAX_VALUE); // ∞ (Unreachable)
    }

    public static void testCycleGraph() {
        Graph graph = new Graph(4); // Create a graph with 4 vertices (A, B, C, D)
        graph.addEdge(0, 1, 1); // A-B: 1
        graph.addEdge(0, 2, 4); // A-C: 4
        graph.addEdge(1, 2, 1); // B-C: 1
        graph.addEdge(1, 3, 2); // B-D: 2
        graph.addEdge(2, 3, 1); // C-D: 1

        int[] distances = graph.dijkstra(0); // Start from vertex A (index 0)

        System.out.println("Graph with a Cycle Test Case");
        checkResult("A", distances[0], 0);
        checkResult("B", distances[1], 1);
        checkResult("C", distances[2], 2);
        checkResult("D", distances[3], 3);
    }

    public static void testSingleNodeGraph() {
        Graph graph = new Graph(1); // Single node A

        int[] distances = graph.dijkstra(0); // Start from vertex A (index 0)

        System.out.println("Single Node Graph Test Case");
        checkResult("A", distances[0], 0);
    }

    public static void testMultiplePathsSameLength() {
        Graph graph = new Graph(4); // Create a graph with 4 vertices (A, B, C, D)
        graph.addEdge(0, 1, 1); // A-B: 1
        graph.addEdge(0, 2, 2); // A-C: 2
        graph.addEdge(1, 2, 1); // B-C: 1
        graph.addEdge(1, 3, 1); // B-D: 1
        graph.addEdge(2, 3, 2); // C-D: 2

        int[] distances = graph.dijkstra(0); // Start from vertex A (index 0)

        System.out.println("Multiple Paths of Same Length Test Case");
        checkResult("A", distances[0], 0);
        checkResult("B", distances[1], 1);
        checkResult("C", distances[2], 2);
        checkResult("D", distances[3], 2);
    }

    // Helper method to check the result and print whether it passes or fails
    public static void checkResult(String vertex, int actual, int expected) {
        System.out.println("A to " + vertex + ": " + actual + " (Expected: " + expected + ")");
        if (actual == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println();
    }

    public static void testLargeSparseGraph() {
        int numNodes = 1000;
        Graph graph = new Graph(numNodes);

        // Sparse graph: Add a few random edges
        graph.addEdge(0, 1, 10);
        graph.addEdge(1, 2, 20);
        graph.addEdge(2, 3, 30);
        graph.addEdge(3, 4, 40);
        graph.addEdge(4, 5, 50);
        graph.addEdge(5, 6, 60);
        graph.addEdge(6, 7, 70);
        graph.addEdge(7, 8, 80);
        graph.addEdge(8, 9, 90);

        int[] distances = graph.dijkstra(0); // Start from vertex 0 (index 0)

        System.out.println("Large Sparse Graph Test Case");
        checkResult("0", distances[0], 0);   // Expected: 0
        checkResult("1", distances[1], 10);  // Expected: 10
        checkResult("2", distances[2], 30);  // Expected: 30 (0 -> 1 -> 2)
        checkResult("3", distances[3], 60);  // Expected: 60 (0 -> 1 -> 2 -> 3)
        checkResult("4", distances[4], 100); // Expected: 100 (0 -> 1 -> 2 -> 3 -> 4)
        checkResult("5", distances[5], 150); // Expected: 150 (0 -> 1 -> 2 -> 3 -> 4 -> 5)
        checkResult("6", distances[6], 210); // Expected: 210 (0 -> 1 -> 2 -> 3 -> 4 -> 5 -> 6)
        checkResult("7", distances[7], 280); // Expected: 280 (0 -> 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7)
        checkResult("8", distances[8], 360); // Expected: 360 (0 -> 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8)
        checkResult("9", distances[9], 450); // Expected: 450 (0 -> 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9)
    }

    public static void testLargeDenseGraph() {
        int numNodes = 100;
        Graph graph = new Graph(numNodes);

        // Dense graph: Connect almost every node to every other node
        for (int i = 0; i < numNodes; i++) {
            for (int j = i + 1; j < numNodes; j++) {
                graph.addEdge(i, j, (i + j) % 10 + 1); // Assign some weight
            }
        }

        int[] distances = graph.dijkstra(0); // Start from vertex 0 (index 0)

        System.out.println("Large Dense Graph Test Case");
        checkResult("0", distances[0], 0);   // Expected: 0
        checkResult("1", distances[1], 2);   // Expected: direct connection (0 -> 1)
        checkResult("2", distances[2], 3);   // Expected: direct connection (0 -> 2)
//        checkResult("50", distances[50], 51);  // Example, verify a random node
//        checkResult("99", distances[99], 100); // Example, verify the last node
        // Note: These expected values are hypothetical, assuming the graph is symmetrically weighted.
    }


}
