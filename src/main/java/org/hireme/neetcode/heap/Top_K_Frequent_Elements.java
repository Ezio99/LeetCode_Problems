package org.hireme.neetcode.heap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Top_K_Frequent_Elements {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> numFrquency = new HashMap<>();
        for (int i : nums) {
            numFrquency.merge(i, 1, Integer::sum);
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        for (int num : numFrquency.keySet()) {
            minHeap.offer(new int[]{num, numFrquency.get(num)});
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        int[] result = new int[k];
        int ctr = 0;
        while (!minHeap.isEmpty()) {
            result[ctr] = minHeap.poll()[0];
            ctr++;
        }

        return result;
    }
}
