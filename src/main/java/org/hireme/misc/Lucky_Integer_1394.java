package org.hireme.misc;

public class Lucky_Integer_1394 {
    public int findLucky(int[] arr) {
        int[] frequency = new int[501];
        int maxNum = Integer.MIN_VALUE; // Not really useful here
        for (int num : arr) {
            frequency[num]++;
            maxNum = Math.max(maxNum, num);
        }

        for (int i = maxNum; i > 0; i--) {
            if (frequency[i] == i) {
                return i;
            }
        }

        return -1;
    }
}
