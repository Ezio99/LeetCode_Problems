package org.hireme.neetcode.heap;

import java.util.BitSet;
import java.util.Comparator;
import java.util.PriorityQueue;

public class K_Closest_Points_To_Origin_973 {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1,int[] o2){
                return Double.compare(Math.sqrt(Math.pow(o2[0],2)+Math.pow(o2[1],2)),
                        Math.sqrt(Math.pow(o1[0],2)+Math.pow(o1[1],2)));

            }
            //Faster
//            @Override
//            public int compare(int[] o1,int[] o2){
//
//
//                return  (o2[0] * o2[0] + o2[1] * o2[1])- (o1[0] * o1[0] + o1[1] * o1[1]);
//
//            }
        });

        for(int[] point: points){
            maxHeap.offer(point);
            if(maxHeap.size()>k){
                maxHeap.poll();
            }
        }

        int[][] result = new int[k][2];
        for(int i=0;i<k;i++){
            result[i] = maxHeap.poll();
        }

        return result;


    }

    //Can also be done using quick select
}
