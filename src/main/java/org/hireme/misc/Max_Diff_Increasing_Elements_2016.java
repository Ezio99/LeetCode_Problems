package org.hireme.misc;

import java.util.PriorityQueue;

public class Max_Diff_Increasing_Elements_2016 {
    public int maximumDifference(int[] nums) {
        int maxDiff = -1, minElement = nums[0];
        int diff;
        for (int i = 1; i < nums.length; i++) {
            diff = nums[i] - minElement;
            if (diff != 0 && diff > maxDiff) maxDiff = diff;
            if (nums[i] < minElement) minElement = nums[i];
        }

        return maxDiff;
    }

    public static void main(String[] args) {
        Max_Diff_Increasing_Elements_2016 obj = new Max_Diff_Increasing_Elements_2016();
        System.out.println(obj.maximumDifference(new int[]{7, 1, 5, 4}));
    }
}
