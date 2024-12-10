package org.hireme.datastructure.graph;

import java.util.Arrays;
import java.util.List;

public class Bellman_Ford {
    /*
    You are given a weighted, directed graph with nn vertices labeled from 0 to n−1,
    and an array edges where edges[i]=[u,v,w] represents a directed edge from node u to node v with
    weight w.

    Compute the shortest path from the source node to every other node.
    If a negative weight cycle exists in the graph, return -1.

    Input:
    n = 5
    edges = [[0, 1, -1], [0, 2, 4], [1, 2, 3], [1, 3, 2], [1, 4, 2], [3, 2, 5], [3, 1, 1], [4, 3, -3]]
    source = 0

    Output:
    [0, -1, 2, -2, 1]
    Explanation:
    - Shortest distances:
      - dist[0] = 0 (source)
      - dist[1] = -1
      - dist[2] = 2
      - dist[3] = -2
      - dist[4] = 1
    - There are no negative weight cycles.

    Example 2:
    Input:
    n = 3
    edges = [[0, 1, 1], [1, 2, -1], [2, 0, -1]]
    source = 0

    Output:
    -1
    Explanation:
    - The graph contains a negative weight cycle:
      - 0 -> 1 -> 2 -> 0
      - Total weight of the cycle = -1.


     */

    // Bellman-Ford Algorithm: Replace this with your implementation
    public static int[] bellmanFord(int n, int[][] edges, int source) {
        // Placeholder: Replace with your solution

        int[] dist = new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[source]=0;

        // Finding the shortest path between each node
        // First iteration considers only 1 edge,2nd 2 edges....
        for (int i = 0; i <n-1; i++) {
            for (int[] edge : edges){
                int from = edge[0];
                int to = edge[1];
                int weight = edge[2];
                if(dist[from] != Integer.MAX_VALUE && dist[from] + weight<dist[to]){
                    dist[to] = dist[from] + weight;
                }
            }
        }

        for (int i = 0; i <n-1; i++) {
            for (int[] edge : edges){
                int from = edge[0];
                int to = edge[1];
                int weight = edge[2];
                //Getting better even after finding best so its in a -ve cycle or reachable by a -ve cycle
                if(dist[from] != Integer.MAX_VALUE && dist[from] + weight<dist[to]){
                    dist[to] = Integer.MIN_VALUE;
                    //Dont immediately return if you want to find all the nodes reachable by a -ve cycle
                    return null;
                }
            }
        }

        return dist;

    }

    public static void main(String[] args) {
        // Define test cases
        List<TestCase> testCases = Arrays.asList(
                new TestCase(
                        5,
                        new int[][]{
                                {0, 1, -1}, {0, 2, 4}, {1, 2, 3}, {1, 3, 2},
                                {1, 4, 2}, {3, 2, 5}, {3, 1, 1}, {4, 3, -3}
                        },
                        0,
                        new int[]{0, -1, 2, -2, 1} // Expected distances
                ),
                new TestCase(
                        3,
                        new int[][]{
                                {0, 1, 1}, {1, 2, -1}, {2, 0, -1}
                        },
                        0,
                        null // Null means negative weight cycle exists
                )
        );


        // Run test cases
        for (int i = 0; i < testCases.size(); i++) {
            TestCase testCase = testCases.get(i);
            int[] result = bellmanFord(testCase.n, testCase.edges, testCase.source);

            // Check if result matches the expected output
            System.out.println("Test Case " + (i + 1) + ":");
            if (testCase.expected == null) {
                System.out.println(result == null ? "PASS" : "FAIL");
            } else {
                System.out.println(Arrays.equals(result, testCase.expected) ? "PASS" : "FAIL");
            }
            System.out.println("Expected: " + Arrays.toString(testCase.expected));
            System.out.println("Got: " + Arrays.toString(result));
        }
    }

    // Test case class
    static class TestCase {
        int n;
        int[][] edges;
        int source;
        int[] expected;

        TestCase(int n, int[][] edges, int source, int[] expected) {
            this.n = n;
            this.edges = edges;
            this.source = source;
            this.expected = expected;
        }
    }


}
