package org.hireme.misc;

import java.util.Arrays;
import java.util.Stack;

public class Max_Chunks_Sorted_769 {
    public static int maxChunksToSorted(int[] arr) {
        int maxSoFar = 0;
        int chunks = 0;

        for (int i = 0; i < arr.length; i++) {
            //When we encounter a number larger than its index it HAS to have a chunk which extends till the place it should be
            //All the numbers from that number to its rightful index will be 1 chunk
            maxSoFar = Math.max(maxSoFar, arr[i]);
            if (maxSoFar == i) {
                chunks++;
            }
        }

        return chunks;

    }

    public static void main(String[] args) {

        System.out.println(maxChunksToSorted(new int[]{4, 3, 2, 1, 0}));
        System.out.println(maxChunksToSorted(new int[]{1, 0, 2, 3, 4}));
        System.out.println(maxChunksToSorted(new int[]{1, 2, 0, 3}));
        System.out.println(maxChunksToSorted(new int[]{0, 2, 1, 4, 3}));
        System.out.println(maxChunksToSorted(new int[]{1, 2, 3, 4, 0}));
        System.out.println(maxChunksToSorted(new int[]{2, 4, 0, 1, 3}));
    }
}
