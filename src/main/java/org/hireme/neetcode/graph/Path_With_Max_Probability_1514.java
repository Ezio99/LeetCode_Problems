package org.hireme.neetcode.graph;

import java.util.*;

public class Path_With_Max_Probability_1514 {

    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        HashMap<Double, List<double[]>> adjacencyList = new HashMap<>();
        int ctr = 0;
        for (int[] edge : edges) {
            adjacencyList.computeIfAbsent((double) edge[0],
                    k -> new ArrayList<>()).add(new double[]{(double) edge[1], succProb[ctr]});

            adjacencyList.computeIfAbsent((double) edge[1],
                    k -> new ArrayList<>()).add(new double[]{(double) edge[0], succProb[ctr]});
            ctr++;
        }


        double[] prob = new double[n];
        Arrays.fill(prob, -1);

        PriorityQueue<double[]> pq = new PriorityQueue<>(new Comparator<double[]>() {
            @Override
            public int compare(double[] o1, double[] o2) {
                return -Double.compare(o1[1], o2[1]);
            }
        });

        pq.offer(new double[]{start_node, 1});
        prob[start_node] = 1;

        while (!pq.isEmpty()) {
            double[] currentNode = pq.poll();
            double currentProb = prob[(int) currentNode[0]];
            if (currentNode[1] < currentProb) {
                continue;
            }

            List<double[]> neighbourList = adjacencyList.get(currentNode[0]);

            if (neighbourList == null) {
                continue;
            }

            for (double[] neighbour : neighbourList) {
                double totalProb = currentProb * neighbour[1];
                if (totalProb > prob[(int) neighbour[0]]) {
                    prob[(int) neighbour[0]] = totalProb;
                    pq.offer(new double[]{neighbour[0], totalProb});
                }
            }


        }

        return prob[end_node] == -1 ? 0 : prob[end_node];

    }


    public static void main(String[] args) {
        Path_With_Max_Probability_1514 obj = new Path_With_Max_Probability_1514();
        // Test case 1: Simple case with a direct path
        int n1 = 3;
        int[][] edges1 = {{0, 1}, {1, 2}, {0, 2}};
        double[] succ = new double[]{0.5, 0.5, 0.2};
        int start1 = 0;
        int end1 = 2;
        System.out.println("Test Case 1 Result: " + obj.maxProbability(n1, edges1, succ, start1, end1));  // Expected: 0.25


    }


}
