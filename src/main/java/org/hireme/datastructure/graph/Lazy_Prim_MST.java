package org.hireme.datastructure.graph;

import java.util.*;

public class Lazy_Prim_MST {
/*
You are given a connected, undirected graph with nn vertices and mm edges. Each edge has a weight associated with it. Your task is to:

    Use Prim's Algorithm to find the Minimum Spanning Tree (MST) of the graph.
    Return the total weight of the MST.
    Optionally, print the edges that are part of the MST.
    edges[]: An array of edges where each edge is represented as [u,v,w],
     indicating an edge between nodes u and v with weight w

 */

    public static int primsMST(int n, List<int[]> edges) {
        HashMap<Integer, List<int[]>> adjacencyList = new HashMap<>();
        boolean[] visited = new boolean[n];
        //Number of edges in a mst will be 1 less than number of nodes
        int[][] mstEdges = new int[n-1][];
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2]-o2[2];
            }
        });

        for (int[] edge : edges){
            //Undirected
            adjacencyList.computeIfAbsent(edge[0],k -> new ArrayList<>()).add(new int[]{edge[0],edge[1],edge[2]});
            adjacencyList.computeIfAbsent(edge[1],k -> new ArrayList<>()).add(new int[]{edge[1],edge[0],edge[2]});
        }

        addUnvisitedEdges(pq,0,adjacencyList,visited);

        int mstCost=0,mctr=0;
        while(!pq.isEmpty()){
            int[] minEdge = pq.poll();

            if(visited[minEdge[1]]){
                continue;
            }

            mstEdges[mctr] = minEdge;
            mstCost+=minEdge[2];
            mctr++;


            if(mctr==n-1){
                break;
            }

            addUnvisitedEdges(pq,minEdge[1],adjacencyList,visited);

        }

        if(mctr<n-1){
            System.out.println("Disconnected graphs cannot have a MST");
            return -1;
        }

        System.out.println(Arrays.deepToString(mstEdges));

        return mstCost;
    }

    public static void addUnvisitedEdges(PriorityQueue<int[]> pq,int node,HashMap<Integer, List<int[]>> adjacencyList,boolean[] visited){
        visited[node] = true;

        for(int[] edge : adjacencyList.getOrDefault(node, new ArrayList<>())){
            if(!visited[edge[1]]){
                pq.offer(new int[]{edge[0],edge[1],edge[2]});
            }

        }
    }

    public static void main(String[] args) {
        // Example test case
        int n = 5;
        List<int[]> edges = Arrays.asList(
                new int[]{0, 1, 2},
                new int[]{0, 3, 6},
                new int[]{1, 3, 8},
                new int[]{1, 2, 3},
                new int[]{1, 4, 5},
                new int[]{2, 4, 7}
        );

        int totalWeight = primsMST(n, edges);
        System.out.println("Total Weight of MST: " + totalWeight);
    }


}
