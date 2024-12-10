package org.hireme.datastructure.graph;

import java.util.*;

public class Tarjans_Strongly_Connected_Components {

    final static int UNVISITED = -1;
    static int id;
    static int scCount;
    static int[] ids;
    static int[] low;
    static boolean[] onStack;
    static HashMap<Integer, List<Integer>> adjacencyList;
    static Stack<Integer> stack;
    static List<List<Integer>> scList;


    // Solve the task using Tarjan's algorithm
    public static void solve(int n, List<int[]> edges) {
        // Input: n (number of nodes), edges (list of edges)
        id = scCount = 0;
        ids = new int[n];
        low = new int[n];
        onStack = new boolean[n];
        adjacencyList = new HashMap<>();
        stack = new Stack<>();
        scList = new ArrayList<>();
        Arrays.fill(ids, UNVISITED);

        for (int[] edge : edges) {
            adjacencyList.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
        }

        for (int i = 0; i < n; i++) {
            if (ids[i] == UNVISITED) {
                dfs(i);
            }
        }


        System.out.println(scList);

/*
Tarjans partitions the graph
Test Case 1:
[[5, 4, 3], [2, 1, 0]]
Test Case 2:
[[2, 1, 0], [3]]
Test Case 3:
[[3], [2], [1], [0]]
 */


    }

    public static void dfs(int at) {
        stack.add(at);
        onStack[at] = true;
        ids[at] = low[at] = id++;

        for (Integer to : adjacencyList.getOrDefault(at, new ArrayList<>())) {
            if (ids[to] == UNVISITED) {
                dfs(to);
            }
            //Backtracking from a visited node or already visited this neighbour from a previous root of DFS
            // In a cycle, the final node which connects to the start will get the low of the start (since it will be smaller)
            // If it wasnt a cycle and this is the terminal (leaf) node then this for loop wont be triggered and the node will be an SC of
            // only itself
            if (onStack[to]) {
                low[at] = Math.min(low[at], low[to]);
            }
        }

        //Visited all neighbours - Make judgement of SCC
        if (ids[at] == low[at]) {
            //is SCC
            List<Integer> componentNodes = new ArrayList<>();
            while (true) {
                Integer node = stack.pop();
                onStack[node] = false;
                low[node] = ids[at];
                componentNodes.add(node);
                if (node == at) {
                    break;
                }
            }
            scList.add(componentNodes);
            scCount++;
        }
    }
//
//    public static void iterativeDfs(int at) {
//        stack.add(at);
//
//
//        do {
//            int currentNode = stack.peek();
//            onStack[currentNode] = true;
//            ids[currentNode] = low[currentNode] = id++;
//
//            boolean isVisitedAllNeighbours = true;
//
//            List<Integer> neigbours = adjacencyList.getOrDefault(currentNode, new ArrayList<>());
//
//            for (Integer to : neigbours) {
//                if (ids[to] == UNVISITED) {
//                    stack.add(to);
//                    isVisitedAllNeighbours=false;
//                    continue;
//                }
//                //This onStack will ensure this is only triggered during backtracking when we want it to happen
//                if (onStack[to]) {
//                    low[currentNode] = Math.min(low[currentNode], low[to]);
//
//                }
//            }
//
//            //Visited all neighbours - Make judgement of SCC
//            if (isVisitedAllNeighbours && ids[currentNode] == low[currentNode]) {
//                //is SCC
//                List<Integer> componentNodes = new ArrayList<>();
//                while (true) {
//                    Integer node = stack.pop();
//                    onStack[node] = false;
//                    low[node] = ids[currentNode];
//                    componentNodes.add(node);
//                    if (node == currentNode) {
//                        break;
//                    }
//                }
//                scList.add(componentNodes);
//                scCount++;
//            } else if (isVisitedAllNeighbours) {
//                s
//
//            }
//        } while (!stack.isEmpty());
//
//    }


    public static void main(String[] args) {
        // Define test cases
        List<TestCase> testCases = Arrays.asList(
                new TestCase(6, Arrays.asList(
                        new int[]{0, 1},
                        new int[]{1, 2},
                        new int[]{2, 0},
                        new int[]{1, 3},
                        new int[]{3, 4},
                        new int[]{4, 5},
                        new int[]{5, 3}
                )),
                new TestCase(4, Arrays.asList(
                        new int[]{0, 1},
                        new int[]{1, 2},
                        new int[]{2, 0}
                )),
                new TestCase(4, Arrays.asList(
                        new int[]{0, 1},
                        new int[]{1, 2},
                        new int[]{2, 3}
                )),
                new TestCase(5, Arrays.asList(
                        new int[]{0, 1},
                        new int[]{1, 2},
                        new int[]{2, 0},
                        new int[]{1, 3},
                        new int[]{3, 4},
                        new int[]{4, 1}
                ))

        );

        // Run test cases
        for (int i = 0; i < testCases.size(); i++) {
            TestCase testCase = testCases.get(i);
            System.out.println("Test Case " + (i + 1) + ":");
            solve(testCase.n, testCase.edges);
        }
    }

    static class TestCase {
        int n;
        List<int[]> edges;

        TestCase(int n, List<int[]> edges) {
            this.n = n;
            this.edges = edges;
        }
    }


}
