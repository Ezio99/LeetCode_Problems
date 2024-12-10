package org.hireme.graph.hard;

import java.util.*;

public class Redundant_Connection_2_685 {

    static int [][] globalEdges;
    static int[] globalAnswer;

    public static int[] findRedundantDirectedConnection(int[][] edges) {
        HashMap<Integer,List<Integer>> adjacencyMatrix = new HashMap<>();
        globalEdges = edges;

        for (int[] edge : edges){
            adjacencyMatrix.computeIfAbsent(edge[0],k -> new ArrayList<>()).add(edge[1]);
        }

        for (int i = edges.length-1; i >-1 ; i--) {
            for (int j = 1; j < edges.length+1; j++) {
                if(adjacencyMatrix.get(j)!=null){
                    if(iterativeDfs(j,adjacencyMatrix,edges.length)){
                        return globalAnswer;
                    }
                }

            }


            System.out.println("here");
        }

        return null;
    }

    private static boolean iterativeDfs(Integer startingNode, HashMap<Integer,List<Integer>> adjacencyMatrix, int numberOfNodes){
        Stack<Integer> stack = new Stack<>();
        Set<Integer> visitedNodes = new HashSet<>();
        int[] previousNodes = new int[numberOfNodes+1];
        Arrays.fill(previousNodes, -2);
        previousNodes[startingNode]=startingNode;
        stack.add(startingNode);

        while(!stack.empty()){
            Integer current = stack.pop();
            if(visitedNodes.add(current)){
                List<Integer> nextNodes = adjacencyMatrix.get(current);
                if(nextNodes!=null && !nextNodes.isEmpty()){
                    for (Integer i : nextNodes){
                        if(previousNodes[i]==-2){
                            previousNodes[i] = current;
                        }
                        else{
                            findEdgeToRemove(adjacencyMatrix,visitedNodes,previousNodes,current,i);
                            return true;
                        }

                    }
                    stack.addAll(nextNodes);


                }
            }
            else {

                return false;
            }


        }

        return false;

    }

    private static void findEdgeToRemove(HashMap<Integer,List<Integer>> adjacencyMatrix,Set<Integer> visitedNodes,
                                         int[] previousNodes,Integer current,Integer nextNode){
        List<int[]> constructedEdges = new ArrayList<>();
        Integer x = current;
        while(!Objects.equals(x, nextNode)){
            int[] edgePair = new int[]{previousNodes[x],x};
            constructedEdges.add(edgePair);
            x = previousNodes[x];
        }
        constructedEdges.add(new int[]{current,nextNode});

        for(int i = globalEdges.length-1; i>-1;i--){
            for(int[] constructedEdge : constructedEdges){
                if(globalEdges[i][0]==constructedEdge[0] && globalEdges[i][1]==constructedEdge[1]){
                    globalAnswer = constructedEdge;
                    return;
                }
            }
        }

    }

    public static void main(String[] args) {
//        int[][] edges = {
//                {1, 2},
//                {1, 3},
//                {2, 3}
//        };

        int[][] edges = {
                {2, 1},
                {3, 1},
                {4, 2},
                {1, 4}
        };


        // Call the findRedundantConnection method
        int[] redundantEdge = findRedundantDirectedConnection(edges);

        // Print the result
        System.out.println("The redundant edge is: [" + redundantEdge[0] + ", " + redundantEdge[1] + "]");
    }
}
