package org.hireme.leetcode.dynamicProblems.medium;

public class Best_SightSeeing_Pair_1014 {


    public static int maxScoreSightseeingPair(int[] values) {
        int indexWithMaxValue = 0,val=0,maxValue = -1;

        for (int i = 1; i < values.length; i++) {
            val = values[i] + values[indexWithMaxValue] + indexWithMaxValue - i;
            if (val > maxValue) {
                maxValue = val;
            }
            //For each number we check if the last greatest number's net contribution is lesser or equal to current number
            // If current number is equal to the contribution of last saved, we keep current
            if (values[i] >= values[indexWithMaxValue] + (indexWithMaxValue - i)) {
                indexWithMaxValue = i;
            }
        }

        return maxValue;
    }

    public static void main(String[] args) {
        int[] values = new int[]{7, 8, 8, 10}; //17

        System.out.println(maxScoreSightseeingPair(values));
    }
}
