package org.hireme.neetcode.graph;

import java.util.*;

public class Min_Cost_To_Connect_Points {

    public int minCostConnectPoints(int[][] points) {
        int n = points.length;


        boolean[] visited = new boolean[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        pq.offer(new int[]{0, 0});
        int sum = 0, ctr = 0;

        while (!pq.isEmpty()) {
            int[] currentNode = pq.poll();

            if (visited[currentNode[0]]) {
                continue;
            }

            visited[currentNode[0]] = true;
            sum += currentNode[1];
            ctr++;

            if (ctr == n) {
                break;
            }

            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    pq.add(new int[]{i, getCost(points[i], points[currentNode[0]])});
                }
            }

        }

        return sum;
    }

    private int getCost(int[] point1, int[] point2) {
        return Math.abs(point1[0] - point2[0]) + Math.abs(point1[1] - point2[1]);
    }

    public static void main(String[] args) {
        Min_Cost_To_Connect_Points obj = new Min_Cost_To_Connect_Points();
        System.out.println(obj.minCostConnectPoints(new int[][]{
                {0, 0}, {2, 2}, {3, 3}, {2, 4}, {4, 2}
        }));
    }

//Adj list creation
    //        List<List<int[]>> adjacencyList = new ArrayList<>();
//
//        for (int i = 0; i < n; i++) {
//            adjacencyList.add(new ArrayList<>());
//        }
//
//        for (int i = 0; i < n; i++) {
//            point1 = points[i];
//            for (int j = i + 1; j < n; j++) {
//                point2 = points[j];
//                dist = Math.abs(point1[0] - point2[0]) + Math.abs(point1[1] - point2[1]);
//                adjacencyList.get(i).add(new int[]{j , dist});
//                adjacencyList.get(j).add(new int[]{i , dist});
//            }
//        }


}
