package org.hireme.datastructure.graph;

import java.util.*;

public class TopologicalSort_Kahn {
    /*
    You are given n tasks labeled from 0 to n−1.
    Each task requires some prerequisites to be completed before it can begin. You are given an array
    dependencies where dependencies[i]=[a,b] means that task b must be completed before task a.
    Return a valid order of tasks to complete all tasks. If there are multiple valid orders, return any of them.
    If it is impossible to complete all tasks due to a cycle, return an empty array.

    Input: n = 6, dependencies = [[1, 0], [2, 1], [3, 2], [4, 2], [5, 3]]
    Output: [0, 1, 2, 3, 4, 5] or any valid topological order.
    Explanation: Tasks must be completed in the given dependency order.

    Input: n = 4, dependencies = [[0, 1], [1, 2], [2, 3], [3, 1]]
    Output: []
    Explanation: There is a cycle in the dependency graph, making it impossible to complete all tasks.

    Input: n = 3, dependencies = []
    Output: [0, 1, 2] or any permutation of tasks.
    Explanation: There are no dependencies, so any order is valid.

     */

    public static List<Integer> topoSortKahn(int n, int[][] edges) {
        int[] nodes = new int[n];
        Queue<Integer> queue = new LinkedList<>();
        HashMap<Integer, List<Integer>> adjacencyList = new HashMap<>();
        List<Integer> topOrder = new ArrayList<>();

        for (int[] edge : edges) {
            nodes[edge[0]] += 1;
            adjacencyList.computeIfAbsent(edge[1], k -> new ArrayList<Integer>()).add(edge[0]);
        }

        for (int i = 0; i < nodes.length; i++) {
            if (nodes[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            Integer currentNode = queue.poll();
            List<Integer> outConnections = adjacencyList.get(currentNode);
            topOrder.add(currentNode);
            if(outConnections!=null && !outConnections.isEmpty()){
                for(Integer i : outConnections){
                    nodes[i]-=1;
                    if(nodes[i]==0){
                        queue.add(i);
                    }
                }
            }
        }

        if (topOrder.size() != n) {
            return new ArrayList<>(); // Return empty list if a cycle exists
        }

        return topOrder;
    }

    public static void main(String[] args) {
        // Create an instance of your solution class


        // Define test cases
        List<TestCase> testCases = Arrays.asList(
                new TestCase(6, new int[][]{{1, 0}, {2, 1}, {3, 2}, {4, 2}, {5, 3}}), // Example 1
                new TestCase(4, new int[][]{{0, 1}, {1, 2}, {2, 3}, {3, 1}}),         // Example 2
                new TestCase(3, new int[][]{}),                                         // Example 3
                new TestCase(5, new int[][]{{0, 1}, {0, 2}, {1, 3}, {1, 4}}),         // Example 4
                new TestCase(1, new int[][]{}),                                          // Example 5: Single task
                new TestCase(4, new int[][]{ {1, 2}, {2, 3}, {3, 1} })                                          // Example 5: Cycle,0 degree
        );

        // Iterate through test cases and print the results
        for (int i = 0; i < testCases.size(); i++) {
            TestCase testCase = testCases.get(i);
            int n = testCase.n;
            int[][] dependencies = testCase.dependencies;

            System.out.println("Test Case " + (i + 1) + ":");
            List<Integer> result = topoSortKahn(n, dependencies); // Call your solution method
            System.out.println(result);
        }
    }

    // Helper class for test cases
    static class TestCase {
        int n;
        int[][] dependencies;

        TestCase(int n, int[][] dependencies) {
            this.n = n;
            this.dependencies = dependencies;
        }
    }
}
