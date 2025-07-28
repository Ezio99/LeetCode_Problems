package org.hireme.misc;

import java.util.PriorityQueue;

public class Minimum_Difference_In_Sums_Removal_2163 {
    //Choose 2*n numbers with min difference
    public long minimumDifference(int[] nums) {
        int n = nums.length / 3;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);

        for (int i = 0; i < 2 * n; i++) {
            maxHeap.offer(nums[i]);
            if (maxHeap.size() > n) {
                maxHeap.poll();
            }
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = nums.length - 1; i > n; i--) {
            minHeap.offer(nums[i]);
            if (minHeap.size() > n) {
                minHeap.poll();
            }
        }

        long diff = 0;
        while (!maxHeap.isEmpty()) {
            diff += maxHeap.poll() - minHeap.poll();
        }

        return diff;
    }

    public static void main(String[] args) {
        Minimum_Difference_In_Sums_Removal_2163 obj = new Minimum_Difference_In_Sums_Removal_2163();
        System.out.println(obj.minimumDifference(new int[]{7, 9, 5, 8, 1, 3}));
        System.out.println(obj.minimumDifference(new int[]{3, 1, 2}));
    }
}
