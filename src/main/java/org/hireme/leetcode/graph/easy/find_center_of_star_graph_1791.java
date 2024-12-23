package org.hireme.leetcode.graph.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class find_center_of_star_graph_1791 {

    public static int findCenter(int[][] edges) {

        // Star graph only has edges between the centre and other nodes
        // Using that, the common node between 2 edges is the centre
        if(edges[0][0]==edges[1][0] ||edges[0][0]==edges[1][1]){
            return edges[0][0];
        }
        else{
            return edges[0][1];
        }


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
