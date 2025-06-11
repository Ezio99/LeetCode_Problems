package org.hireme.neetcode.heap;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.PriorityQueue;

public class Kth_Largest_Element_Stream {

    int k;
    PriorityQueue<Integer> minHeap;

    public Kth_Largest_Element_Stream(int k, int[] nums) {
        minHeap = new PriorityQueue<>();
        this.k = k;
        for (int i : nums) {
            minHeap.offer(i);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
    }

    public int add(int val) {
        minHeap.offer(val);
        if (minHeap.size() > k) {
            minHeap.poll();
        }
        return minHeap.peek();
    }
}
