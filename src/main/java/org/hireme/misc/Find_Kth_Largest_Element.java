package org.hireme.misc;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Find_Kth_Largest_Element {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i: nums){
            pq.offer(i);
            if(pq.size()>k){
                pq.poll();
            }
        }

        return pq.poll();


    }

    public static void main(String[] args) {
        Find_Kth_Largest_Element obj = new Find_Kth_Largest_Element();
        System.out.println(obj.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
    }


}
