//package org.hireme.graph.medium;
//
//
//import java.util.*;
//
///*
//    Topologicial sort : BFS
// */
//public class Loud_and_rich {
//
//    public int[] loudAndRich(int[][] richer, int[] quiet) {
//        //The earlier the richer
//        int[] sortedRich = new int[quiet.length];
//        int[] degree = new int[quiet.length];
////        boolean[] visited = new boolean[quiet.length];
//        Queue<Integer> queue = new LinkedList<>();
//        HashMap<Integer,List<Integer>> adjMatrix = new HashMap<>();
//
//
//        for (int[] ints : richer) {
//            adjMatrix.computeIfAbsent(ints[1], k -> new ArrayList<>()).add(ints[0]);
//
//        }
//
//        for (int i = 0; i < quiet.length; i++) {
//            if(adjMatrix.get(i)!=null){
//                degree[i] = adjMatrix.get(i).size();
//            }
//            else {
//                degree[i] = 0;
//            }
//
//        }
//
//
//
//
//    }
//
//    private void get0DegreeNodes(HashMap<Integer,List<Integer>> adjMatrix,int[] sortedRich){
//
//    }
//}
