package org.hireme.misc;

import java.util.Arrays;

//Not correct approach
public class minimum_number_of_operations_to_move_all_balls_to_each_box_1769 {
    public static int[] minOperations(String boxes) {
        int length=boxes.length();
        int[] result = new int[length];
        int[] prefixSumArray = new int[length];
        int numberOfBalls = 0, ctr = 0;

        for (int i = 0; i < length; i++) {
            numberOfBalls += boxes.charAt(i) == '1' ? 1 : 0;
            prefixSumArray[ctr] = numberOfBalls;
            ctr++;
        }

        int ballsInLeft, ballsInRight;
        for (int i = 0; i < length; i++) {
            ballsInLeft = i == 0 ? 0 : prefixSumArray[i - 1];
            ballsInRight = i == length - 1 ? 0 : prefixSumArray[length-1] - prefixSumArray[i];
            result[i] = ballsInLeft+ballsInRight;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(minOperations("110")));
        System.out.println(Arrays.toString(minOperations("001011")));
    }

}
