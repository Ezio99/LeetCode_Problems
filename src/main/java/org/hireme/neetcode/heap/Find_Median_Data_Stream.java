package org.hireme.neetcode.heap;

import java.util.PriorityQueue;

public class Find_Median_Data_Stream {


    PriorityQueue<Integer> rightMinHeap;
    PriorityQueue<Integer> leftMaxHeap;

    public Find_Median_Data_Stream() {
        rightMinHeap = new PriorityQueue<>();
        leftMaxHeap = new PriorityQueue<>((a, b) -> b - a);
    }

    public void addNum(int num) {
        //Add to right min heap for first element and if its greater than the min
        if (rightMinHeap.isEmpty() || num >= rightMinHeap.peek()) {
            rightMinHeap.offer(num);
        } else {
            leftMaxHeap.offer(num);
        }
        //Keeping leftmaxheap always smaller in size so median is always in right in case its odd
        if (leftMaxHeap.size() > rightMinHeap.size()) {
            rightMinHeap.offer(leftMaxHeap.poll());
        } else if (rightMinHeap.size() > leftMaxHeap.size() + 1) {
            leftMaxHeap.offer(rightMinHeap.poll());
        }

    }

    //Didnt do null checks since guaranteed that we will always atleast get 1 element before findmedian called
    public double findMedian() {
        if ((rightMinHeap.size() + leftMaxHeap.size()) % 2 == 0) {
            return ((double) rightMinHeap.peek() + leftMaxHeap.peek()) / 2.0;
        } else {
            return rightMinHeap.peek();
        }

    }

}
