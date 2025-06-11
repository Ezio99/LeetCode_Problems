package org.hireme.datastructure.graph;


import java.util.*;


public class Dijkstra {

    /*

    Dijkstra also works for undirected
    You are given a graph with n nodes labeled from 0 to n−1 and an array edges where edges[i]=[u,v,w]
    represents a directed edge from node u to node v with weight w.
    You are also given a source node source and a destination node destination.
    Your task is to find the shortest path from the source node to the destination node. If there is no path, return -1.

    Input:
    n = 6
    edges = [[0, 1, 2], [0, 2, 4], [1, 2, 1], [1, 3, 7], [2, 4, 3], [3, 5, 1], [4, 5, 2]]
    source = 0
    destination = 5

    Output: 10
    Explanation:
    2+1+3+2 = 8
    The shortest path is 0 -> 1 -> 2 -> 4 -> 5 with a total weight of 10.


    Input:
    n = 5
    edges = [[0, 1, 3], [1, 2, 2], [2, 3, 4], [3, 1, 1]]
    source = 0
    destination = 4

    Output: -1
    Explanation:
    There is no path from 0 to 4.


     */

    public static int dijkstra(int n, int[][] edges, int source, int destination) {
        // Placeholder implementation
        HashMap<Integer, List<Edge>> adjacencyList = new HashMap<>();
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;
        boolean[] visited = new boolean[n];


        for (int[] edge : edges) {
            adjacencyList.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(new Edge(edge[1], edge[2]));
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        pq.offer(new int[]{source, 0});

        //current[0]=node being processed
        //current[1]=Proposed Distance from start
        // dist[index]= Also proposed Distance from start but once we visit the node, it becomes final
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int currentNode = current[0];
            int currentDist = current[1];

            if (visited[currentNode]) {
                continue;
            }

            // We only visit node when we are sure it is the minimum distance to it
            // So if this is our second time coming here, the proposed distance will be bigger than what had already got
            // DO NOT need this when already checking visit?
//            if(current[1]>dist[current[0]]){
//                continue;
//            }

            visited[currentNode] = true;

            if (currentNode == destination) {
                return dist[destination];
            }

            List<Edge> outConnections = adjacencyList.get(currentNode);
            if (outConnections != null) {
                for (Edge e : outConnections) {
                    int newDist = currentDist + e.weight;
                    if (!visited[e.to] && newDist < dist[e.to]) {
                        dist[e.to] = newDist;
                        pq.offer(new int[]{e.to, newDist});
                    }
                }
            }


        }


        return -1;
    }

    public static void main(String[] args) {
        // Define test cases
        List<TestCase> testCases = Arrays.asList(
                new TestCase(6, new int[][]{{0, 1, 2}, {0, 2, 4}, {1, 2, 1}, {1, 3, 7}, {2, 4, 3}, {3, 5, 1}, {4, 5, 2}}, 0, 5, 8),
                new TestCase(3, new int[][]{{0, 1, 4}, {1, 2, 6}, {0, 2, 8}}, 0, 2, 8),
                new TestCase(5, new int[][]{{0, 1, 3}, {1, 2, 2}, {2, 3, 4}, {3, 1, 1}}, 0, 4, -1)
        );

        // Run test cases
        for (int i = 0; i < testCases.size(); i++) {
            TestCase testCase = testCases.get(i);
            int result = dijkstra(testCase.n, testCase.edges, testCase.source, testCase.destination); // Replace with your solution
            System.out.println("Test Case " + (i + 1) + ": " + (result == testCase.expected ? "PASS" : "FAIL"));
            System.out.println("Expected: " + testCase.expected + ", Got: " + result);
        }
    }

    // Test case class
    static class TestCase {
        int n;
        int[][] edges;
        int source;
        int destination;
        int expected;

        TestCase(int n, int[][] edges, int source, int destination, int expected) {
            this.n = n;
            this.edges = edges;
            this.source = source;
            this.destination = destination;
            this.expected = expected;
        }
    }

    static class Edge {
        int to;
        int weight;

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    // Replace this with your Dijkstra implementation

}
