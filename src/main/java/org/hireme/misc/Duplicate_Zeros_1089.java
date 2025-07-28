package org.hireme.misc;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Duplicate_Zeros_1089 {
    public void duplicateZeros(int[] arr) {
        int numZeros = 0;
        for (int i = 0; i < arr.length - numZeros; i++) {
            if (arr[i] == 0) numZeros++;
        }
        if (numZeros == 0) return;

        int boundary = arr.length - 2 - 1, r = arr.length - 1;
        while (r > boundary) {
            if (arr[boundary] == 0) {
                arr[r--] = 0;
                arr[r--] = 0;
                boundary--;
            } else {
                arr[r--] = arr[boundary--];
            }
        }

        System.out.println(Arrays.toString(arr));

    }

    public static void main(String[] args) {
        Duplicate_Zeros_1089 obj = new Duplicate_Zeros_1089();
        obj.duplicateZeros(new int[]{1, 0, 2, 3, 0, 4, 5, 0});
    }
}
