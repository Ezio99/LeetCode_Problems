package org.hireme.neetcode.twopointer;

import java.util.Arrays;

public class Two_Integer_Sum_2 {

    public static int[] twoSum(int[] numbers, int target) {
        int j = numbers.length - 1, i = 0, sum = 0;

        while (i < j) {
            sum = numbers[i] + numbers[j];

            if (sum > target) {
                j--;
            } else if (sum < target) {
                i++;
            }
            else {
                break;
            }


        }


        return new int[]{i+1, j+1};

    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{1, 2, 3, 4}, 3)));
    }
}
