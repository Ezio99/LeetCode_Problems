package org.hireme.graph.medium;

import java.util.*;

public class Find_Eventual_Safe_States_802 {

    // Anytime you encounter a cycle it means that its not safe
    // Its possible to just keep going through a cycle so the condition of every possible path breaks
    // Once we find that a node's some path will lead to a cycle (unsafe), any node which goes to this node
    // will also be unsafe.
    public static List<Integer> eventualSafeNodes(int[][] graph) {

        List<Integer> terminalNodes = new ArrayList<>();
        Queue<Integer> zeroDegreeNodes = new LinkedList<>();
        HashMap<Integer, int[]> cloneGraph = new HashMap<>();

        for (int i = 0; i < graph.length; i++) {
            if (graph[i].length == 0) {
                terminalNodes.add(i);
                zeroDegreeNodes.add(i);
            } else {
                cloneGraph.put(i, graph[i]);
            }
        }

        if (terminalNodes.isEmpty()) {
            return new ArrayList<>();
        }

        while (!zeroDegreeNodes.isEmpty()) {
            Integer node = zeroDegreeNodes.poll();
            HashMap<Integer, int[]> clonecloneGraph = new HashMap<>();
            for (Integer i : cloneGraph.keySet()) {
                int[] nodeList = cloneGraph.get(i);
                int nodeIndex = Arrays.binarySearch(nodeList, node);

                if(nodeIndex<0){
                    clonecloneGraph.put(i, nodeList);
                    continue;
                }
                nodeList = Arrays.stream(nodeList).filter(x -> x!=node).toArray();
                if (nodeList.length == 0) {
                    terminalNodes.add(i);
                    zeroDegreeNodes.add(i);
                } else {
                    clonecloneGraph.put(i, nodeList);
                }
            }
            cloneGraph = clonecloneGraph;
        }

        terminalNodes.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        return terminalNodes;


    }

    public static void main(String[] args) {
        // Define test cases
        List<int[][]> testCases = Arrays.asList(
//                new int[][]{{1, 2}, {2, 3}, {5}, {0}, {5}, {}, {}}, // Example 1
                new int[][]{{1, 2, 3, 4}, {1, 2}, {3, 4}, {0, 4}, {}}, // Example 2
                new int[][]{{}, {0,2,3,4}, {3}, {4}, {}}                             // Example 3: Empty graph
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
