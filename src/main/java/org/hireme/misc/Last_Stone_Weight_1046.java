package org.hireme.misc;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Last_Stone_Weight_1046 {
    public int lastStoneWeight(int[] stones) {
        //Max heap
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for (int stone : stones) {
            pq.offer(stone);
        }

        int stone1, stone2, stone3;
        while (pq.size() > 1) {
            stone1 = pq.poll();
            stone2 = pq.poll();
            stone3 = Math.abs(stone1 - stone2);
            if(stone3!=0){
                pq.offer(stone3);
            }

        }

        return pq.isEmpty() ? 0 : pq.poll();
    }
}
