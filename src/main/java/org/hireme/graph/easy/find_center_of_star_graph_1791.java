package org.hireme.graph.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class find_center_of_star_graph_1791 {

    public static int findCenter(int[][] edges) {
        int numOfEdges = edges.length;
        HashMap<Integer, List<Integer>> edgesPerNode = new HashMap<>();

        for (int[] edgePair : edges) {

            edgesPerNode.computeIfAbsent(edgePair[0],k -> new ArrayList<>()).add(edgePair[1]);
            edgesPerNode.computeIfAbsent(edgePair[1],k -> new ArrayList<>()).add(edgePair[0]);

            if(edgesPerNode.get(edgePair[0]).size()==numOfEdges){
                return edgePair[0];
            }

            if(edgesPerNode.get(edgePair[1]).size()==numOfEdges){
                return edgePair[1];
            }

        }
        return 0;
    }

    public static void main(String[] args) {
        int[][] edges = {
                {1, 2},
                {2, 3},
                {4, 2}
        };

        // Call the findCenter method
        int center = findCenter(edges);

        // Print the result
        System.out.println("The center of the star graph is: " + center);
    }


}
