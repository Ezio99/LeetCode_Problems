package org.hireme.leetcode.graph.medium;

import java.util.*;

public class Find_Eventual_Safe_States_802 {

    // Anytime you encounter a cycle it means that its not safe
    // Its possible to just keep going through a cycle so the condition of every possible path breaks
    // Once we find that a node's some path will lead to a cycle (unsafe), any node which goes to this node
    // will also be unsafe.
    public static List<Integer> eventualSafeNodes(int[][] graph) {

        int n = graph.length;
        int[] nodeStatus = new int[n]; // -1: unsafe, 0: unknown, 1: safe
        boolean[] visited = new boolean[n];
        boolean[] inStack = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (nodeStatus[i] == 0) {
                iterativeDFS(nodeStatus, graph, i, visited, inStack);
            }
        }

        List<Integer> finalAnswer = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (nodeStatus[i] == 1) {
                finalAnswer.add(i);
            }
        }
        return finalAnswer;


    }


    public static void iterativeDFS(int[] nodeStatus, int[][] graph, int at,boolean[] visited,boolean[] inStack) {

        Stack<Integer> callStack = new Stack<>();
        callStack.push(at);

        while (!callStack.isEmpty()) {
            int currentNode = callStack.peek();

            if (visited[currentNode]) {
                // All neighbors processed, backtrack
                callStack.pop();
                inStack[currentNode] = false;

                if (nodeStatus[currentNode] == 0) {
                    nodeStatus[currentNode] = 1; // Safe if not marked unsafe
                }
                continue;
            }

            // Mark the node as visited and in the stack
            visited[currentNode] = true;
            inStack[currentNode] = true;

            boolean hasUnprocessedNeighbor = false;
            for (int neighbor : graph[currentNode]) {
                if (nodeStatus[neighbor] == -1 || inStack[neighbor]) {
                    // Cycle detected or unsafe neighbor
                    nodeStatus[currentNode] = -1;
                    callStack.pop();
                    inStack[currentNode] = false;
                    return;
                } else if (nodeStatus[neighbor] == 0) {
                    // Explore unprocessed neighbor
                    if (!visited[neighbor]) {
                        callStack.push(neighbor);
                        hasUnprocessedNeighbor = true;
                    }
                }
            }

            if (!hasUnprocessedNeighbor) {
                // If no neighbors to process, mark as safe and backtrack
                nodeStatus[currentNode] = 1;
                callStack.pop();
                inStack[currentNode] = false;
            }

        }

    }


    public static List<Integer> eventualSafeNodesTopSort(int[][] graph) {

        //Take outdegree instead of in degree
        int[] outDegreeOfNodes = new int[graph.length];
        Queue<Integer> zeroDegreeNodesQueue = new LinkedList<>();
        HashMap<Integer, List<Integer>> reverseAdjacencyList = new HashMap<>();
        List<Integer> finalAnswer = new ArrayList<>();

        for (int i = 0; i < graph.length; i++) {
            int[] neighbours = graph[i];
            outDegreeOfNodes[i] = neighbours.length;
            if (outDegreeOfNodes[i] == 0) {
                zeroDegreeNodesQueue.add(i);
                continue;
            }
            for (int j = 0; j < neighbours.length; j++) {
                //j is being pointed at by i
                reverseAdjacencyList.computeIfAbsent(neighbours[j], k -> new ArrayList<>()).add(i);
            }

        }

        while (!zeroDegreeNodesQueue.isEmpty()) {
            int currentNode = zeroDegreeNodesQueue.poll();
            finalAnswer.add(currentNode);

            for (Integer pointingAtMe : reverseAdjacencyList.getOrDefault(currentNode, Collections.emptyList())) {
                if (--outDegreeOfNodes[pointingAtMe] == 0) {
                    zeroDegreeNodesQueue.add(pointingAtMe);
                }
            }

        }

        finalAnswer.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        return finalAnswer;


    }

    public static void main(String[] args) {
        // Define test cases
        List<int[][]> testCases = Arrays.asList(
//                new int[][]{{1, 2}, {2, 3}, {5}, {0}, {5}, {}, {}},
                new int[][]{{1, 2, 4}, {0, 2, 4}, {3, 4}, {4}, {2}},
                new int[][]{{1, 2, 3, 4}, {1, 2}, {3, 4}, {0, 4}, {}} // Example 2
//                new int[][]{{1,2,4}, {0,2,4}, {3,4}, {4},{2}}                          // Example 3: Empty graph
//                new int[][]{{1}, {2}, {3}, {4}, {}},                 // Example 4: Linear graph
//                new int[][]{{1}, {2}, {0}, {4}, {5}, {3}}        // Example 5: Cycle with safe nodes
        );

        // Iterate through test cases and print the results
        for (int i = 0; i < testCases.size(); i++) {
            int[][] graph = testCases.get(i);
            List<Integer> result = eventualSafeNodes(graph); // Call your solution method
            System.out.println("Test Case " + (i + 1) + ": " + result);
        }
    }

}
