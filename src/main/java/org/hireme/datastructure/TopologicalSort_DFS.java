package org.hireme.datastructure;

import java.util.*;

public class TopologicalSort_DFS {
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

    static boolean isContainCycle;

    public static List<Integer> topoSortDFS(int n, int[][] edges) {
        isContainCycle = false;
        HashMap<Integer, List<Integer>> adjacencyList = new HashMap<>();
        int[] visited = new int[n];
        List<Integer> topOrder = new ArrayList<>();


        for (int[] edge : edges) {
            adjacencyList.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
        }

        int vctr=1;
        for (int i = 0; i < n; i++) {
            //If not yet visited this node
            if(visited[i]==0){
                dfs(adjacencyList,i,vctr,visited,topOrder);
            }
            if(isContainCycle){
                return new ArrayList<>();
            }
            vctr+=1;

        }

        return topOrder.reversed();





    }

    public static void dfs(HashMap<Integer, List<Integer>> adjacencyList,int startNode,int vctr,int[] visited,List<Integer> topOrder){
        if(isContainCycle){
            return;
        }

        visited[startNode]=vctr;
        List<Integer> outConnections = adjacencyList.get(startNode);

        if(outConnections!=null && !outConnections.isEmpty()){
            for(Integer i: outConnections){
                if(isContainCycle){
                    return;
                }
                if(visited[i]==0){
                    dfs(adjacencyList,i,vctr,visited,topOrder);
                }
                //Cycle detected
                else if (visited[i]==vctr) {
                    // This won't work because all we're doing is setting the coy of the address I received to null
                    //The actual data is still present, or the reference held by the function calling this is not null
//                    topOrder=null;


                    isContainCycle=true;
                    return;
                }
            }
        }

        topOrder.add(startNode);


    }

    public static void main(String[] args) {

        // Define test cases
        List<TopologicalSort_Kahn.TestCase> testCases = Arrays.asList(
                new TopologicalSort_Kahn.TestCase(6, new int[][]{{1, 0}, {2, 1}, {3, 2}, {4, 2}, {5, 3}}), // Example 1
                new TopologicalSort_Kahn.TestCase(4, new int[][]{{0, 1}, {1, 2}, {2, 3}, {3, 1}}),         // Example 2
                new TopologicalSort_Kahn.TestCase(3, new int[][]{}),                                         // Example 3
                new TopologicalSort_Kahn.TestCase(5, new int[][]{{0, 1}, {0, 2}, {1, 3}, {1, 4}}),         // Example 4
                new TopologicalSort_Kahn.TestCase(1, new int[][]{}),                                          // Example 5: Single task
                new TopologicalSort_Kahn.TestCase(4, new int[][]{ {1, 2}, {2, 3}, {3, 1} })                                          // Example 5: Cycle,0 degree
        );

        // Iterate through test cases and print the results
        for (int i = 0; i < testCases.size(); i++) {
            TopologicalSort_Kahn.TestCase testCase = testCases.get(i);
            int n = testCase.n;
            int[][] dependencies = testCase.dependencies;

            System.out.println("Test Case " + (i + 1) + ":");
            List<Integer> result = topoSortDFS(n, dependencies); // Call your solution method
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
