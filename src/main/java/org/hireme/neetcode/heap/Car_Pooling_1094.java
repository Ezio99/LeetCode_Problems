package org.hireme.neetcode.heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Car_Pooling_1094 {
    public boolean carPooling(int[][] trips, int capacity) {
//        Arrays.sort(trips, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                return o1[1] - o2[1];
//            }
//        });

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]==o2[0]){
                    return o1[1] - o2[1];
                }
                return o1[0] - o2[0];
            }
        });


        for (int[] trip : trips) {
            minHeap.offer(new int[]{trip[1], trip[0]});
            minHeap.offer(new int[]{trip[2], -1 * trip[0]});
        }

        int currCap = 0;
        int[] currTrip;
        while (!minHeap.isEmpty()) {
            currTrip = minHeap.poll();
            currCap += currTrip[1];
            if (currCap > capacity) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Car_Pooling_1094 obj = new Car_Pooling_1094();
        System.out.println(obj.carPooling(new int[][]{
                {2, 1, 5},
                {3, 3, 7}
        }, 4));
    }
}
