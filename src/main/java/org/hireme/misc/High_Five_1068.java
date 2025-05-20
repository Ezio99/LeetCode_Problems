package org.hireme.misc;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class High_Five_1068 {

    public int[][] highFive(int[][] items) {
        HashMap<Integer, PriorityQueue<Integer>> marksPerId = new HashMap<>();
        int idCount = 0;

        for (int[] item : items) {
            if (!marksPerId.containsKey(item[0])) {
                idCount++;
            }
            marksPerId.computeIfAbsent(item[0], k -> new PriorityQueue<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2 - o1;
                }
            })).offer(item[1]);
        }

        int[][] result = new int[idCount][2];
        int sum, ctr = 0;
        for (int id : marksPerId.keySet()) {
            sum = 0;
            for (int i = 0; i < 5; i++) {
                sum += marksPerId.get(id).poll();
            }
            result[ctr++][0] = id;
            result[ctr++][1] = sum / 5;
        }

        return result;


    }
}
