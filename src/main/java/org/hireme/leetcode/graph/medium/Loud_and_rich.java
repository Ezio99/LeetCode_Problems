package org.hireme.leetcode.graph.medium;


import java.util.*;


public class Loud_and_rich {

    public static int[] loudAndRich(int[][] richer, int[] quiet) {
        HashMap<Integer, List<Integer>> adjacencyList = new HashMap<>();
        boolean[] visited = new boolean[quiet.length];
        List<List<Integer>> topOrder = new ArrayList<>();

        for (int[] edge : richer) {
            adjacencyList.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
        }

//        int vctr = 1;
        List<Integer> currentOrder = new ArrayList<>();
        for (int i = 0; i < quiet.length; i++) {
            if (!visited[i]){
                dfs(adjacencyList,i,visited,currentOrder);
            }
        }

        currentOrder=currentOrder.reversed();
        System.out.println(currentOrder);

        return null;



    }

    public static void dfs(HashMap<Integer, List<Integer>> adjacencyList ,int at,boolean[] visited,List<Integer> topOrder){
        visited[at]=true;

        //Not checking for cycles since question says it wont happen
        for (Integer to : adjacencyList.getOrDefault(at,Collections.emptyList())){
            if(!visited[to]){
                dfs(adjacencyList,to,visited,topOrder);
            }
        }

        topOrder.add(at);
    }

    public static void main(String[] args) {
        // Define test cases
        int[][] richer1 = {{1, 0}, {2, 1}, {3, 1}, {3, 7}, {4, 3}, {5, 3}, {6, 3}};
        int[] quiet1 = {3, 2, 5, 4, 6, 1, 7, 0};
        int[][] richer2 = {{0, 1}, {1, 2}, {2, 3}};
        int[] quiet2 = {3, 2, 5, 4};

        // Create the solution object


        // Test case 1
        System.out.println("Test Case 1:");
        System.out.println("Richer: " + Arrays.deepToString(richer1));
        System.out.println("Quiet: " + Arrays.toString(quiet1));
        int[] result1 = loudAndRich(richer1, quiet1);
        System.out.println("Result: " + Arrays.toString(result1));

        // Test case 2
        System.out.println("\nTest Case 2:");
        System.out.println("Richer: " + Arrays.deepToString(richer2));
        System.out.println("Quiet: " + Arrays.toString(quiet2));
        int[] result2 = loudAndRich(richer2, quiet2);
        System.out.println("Result: " + Arrays.toString(result2));

        // Additional test cases
        System.out.println("\nAdditional Test Case:");
        int[][] richer3 = {};
        int[] quiet3 = {0};
        System.out.println("Richer: " + Arrays.deepToString(richer3));
        System.out.println("Quiet: " + Arrays.toString(quiet3));
        int[] result3 = loudAndRich(richer3, quiet3);
        System.out.println("Result: " + Arrays.toString(result3));
    }
}
