package org.hireme.neetcode.heap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Top_K_Frequent_Elements_347 {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.merge(nums[i], 1, Integer::sum);
        }

        //Min heap
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        for (int key : map.keySet()) {
            pq.add(new int[]{key, map.get(key)});
            if (pq.size() > k) {
                pq.poll();
            }
        }

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = pq.poll()[0];
        }

        return result;

    }
}
