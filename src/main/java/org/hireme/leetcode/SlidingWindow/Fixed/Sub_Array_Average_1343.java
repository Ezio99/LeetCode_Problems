package org.hireme.leetcode.SlidingWindow.Fixed;

public class Sub_Array_Average_1343 {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int ctr = 0;
        int l = 0, sum = 0;

        for (int r = 0; r < arr.length; r++) {
            sum += arr[r];
            if (r - l + 1 == k) {
                if (sum / k >= threshold) {
                    ctr++;
                }
                sum -= arr[l];
                l++;
            }
        }

        return ctr;
    }

    public static void main(String[] args) {
        Sub_Array_Average_1343 obj = new Sub_Array_Average_1343();
        System.out.println(obj.numOfSubarrays(new int[]{11,13,17,23,29,31,7,5,2,3}, 3, 5));
    }
}
