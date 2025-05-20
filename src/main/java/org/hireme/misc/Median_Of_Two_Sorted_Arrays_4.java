package org.hireme.misc;

import java.util.Arrays;

public class Median_Of_Two_Sorted_Arrays_4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int arr1Length = nums1.length, arr2Length = nums2.length;
        int totalLength = arr1Length + arr2Length;
        int[] medianIndexes = new int[2];
        boolean isEven = totalLength % 2 == 0;
        int[] combinedArr = new int[totalLength];
        int i1 = 0, i2 = 0, ctr = 0;
        while (i1 < arr1Length && i2 < arr2Length) {
            if (nums1[i1] < nums2[i2]) {
                combinedArr[ctr] = nums1[i1];
                i1++;
            } else {
                combinedArr[ctr] = nums2[i2];
                i2++;
            }
            ctr++;
        }

        for (int i = i1; i < arr1Length; i++) {
            combinedArr[ctr++] = nums1[i];
        }

        for (int i = i2; i < arr2Length; i++) {
            combinedArr[ctr++] = nums2[i];
        }

        if (totalLength % 2 == 0) {
            int x = combinedArr[(totalLength / 2) - 1];
            int y = combinedArr[((int) Math.ceil((totalLength + 1) / 2.0) - 1)];
            return (x + y) / 2.0;
        }

        return (combinedArr[((totalLength + 1) / 2) - 1]);

    }

    public static void main(String[] args) {
        Median_Of_Two_Sorted_Arrays_4 obj = new Median_Of_Two_Sorted_Arrays_4();
        System.out.println(obj.findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
    }

}
