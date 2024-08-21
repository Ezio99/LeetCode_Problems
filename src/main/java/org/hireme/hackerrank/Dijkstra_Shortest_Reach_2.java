package org.hireme.hackerrank;

import java.util.*;

public class Dijkstra_Shortest_Reach_2 {
    public static List<Integer> shortestReach(int n, List<List<Integer>> edges, int s) {
        // Write your code here
        List<Integer> dist = new ArrayList<>();
        boolean[] visited = new boolean[n];
        HashMap<Integer, List<int[]>> adjacencyMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            dist.add(-1);
        }

        dist.set(s-1, 0);

        for (List<Integer> edge : edges) {
            adjacencyMap.computeIfAbsent(edge.get(0) - 1, k -> new ArrayList<>()).add(new int[]{edge.get(1) - 1, edge.get(2)});
            adjacencyMap.computeIfAbsent(edge.get(1) - 1, k -> new ArrayList<>()).add(new int[]{edge.get(0) - 1, edge.get(2)});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

//        List<Integer> first = new ArrayList<>();
//        first.add(s-1);
//        first.add(0);

        pq.offer(new int[]{s-1,0});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();

            if (visited[curr[0]]) {
                continue;
            }
            visited[curr[0]] =  true;

            if (dist.get(curr[0]) != -1 && dist.get(curr[0]) < curr[1]) {
                continue;
            }

            if(adjacencyMap.get(curr[0])==null){
                continue;
            }


            for (int[] neighbourEdge : adjacencyMap.get(curr[0])) {
                if (visited[neighbourEdge[0]]) {
                    continue;
                }

                int newDist = dist.get(curr[0]) + neighbourEdge[1];
                if (dist.get(neighbourEdge[0]) == -1 || newDist < dist.get(neighbourEdge[0])) {
                    dist.set(neighbourEdge[0], newDist);
//                    List<Integer> newEdge = new ArrayList<>();
//                    newEdge.add(neighbourEdge[0]);
//                    newEdge.add(newDist);
                    pq.offer(new int[]{neighbourEdge[0], newDist});
                }

            }
        }

        dist.remove(s-1);
//        List<Integer> result = new ArrayList<>();
//        for (int i = 0; i < n; i++) {
//            if(i==s-1){
//                continue;
//            }
//            result.add(dist.get(i));
//        }


        return dist;
    }

    public static void main(String[] args) {
        int numOfNodes = 4; // Number of nodes

        List<List<Integer>> edges = new ArrayList<>();
        for (int i = 0; i < numOfNodes; i++) {
            edges.add(new ArrayList<>()); // Initialize the adjacency list
        }

        // Each edge is represented as a list of 3 integers: [u, v, w]
        List<Integer> edge1 = new ArrayList<>();
        edge1.add(1); // u
        edge1.add(2); // v
        edge1.add(24); // w

        List<Integer> edge2 = new ArrayList<>();
        edge2.add(1); // u
        edge2.add(4); // v
        edge2.add(20); // w

        List<Integer> edge3 = new ArrayList<>();
        edge3.add(3); // u
        edge3.add(1); // v
        edge3.add(3); // w

        List<Integer> edge4 = new ArrayList<>();
        edge4.add(4); // u
        edge4.add(3); // v
        edge4.add(12); // w

        // Add edges to the list
        edges.get(0).addAll(edge1);
        edges.get(1).addAll(edge2);
        edges.get(2).addAll(edge3);
        edges.get(3).addAll(edge4);

        int startNode = 1; // Starting node for Dijkstra's algorithm

        List<Integer> shortestDistances = shortestReach(numOfNodes, edges, startNode);

        // Print the shortest distances to all other nodes from the start node
        for (int distance : shortestDistances) {
            System.out.print(distance + " ");
        }
    }
}
