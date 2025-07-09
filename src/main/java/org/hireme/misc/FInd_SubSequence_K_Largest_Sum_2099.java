package org.hireme.misc;

import java.util.Comparator;
import java.util.PriorityQueue;

public class FInd_SubSequence_K_Largest_Sum_2099 {
    public int[] maxSubsequence(int[] nums, int k) {
        boolean[] pick = new boolean[nums.length];
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        for (int i = 0; i < nums.length; i++) {
            if (minHeap.size() < k) {
                minHeap.offer(new int[]{nums[i], i});
                pick[i] = true;
            } else if (minHeap.peek()[0] < nums[i]) {
                minHeap.offer(new int[]{nums[i], i});
                pick[i] = true;
                pick[minHeap.poll()[1]] = false;
            }
        }


        int[] result = new int[k];
        int ctr = 0;
        for (int i = 0; i < nums.length; i++) {
            if (pick[i]) {
                result[ctr++] = nums[i];
            }
        }

        return result;
    }


}
