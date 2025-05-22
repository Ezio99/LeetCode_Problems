package org.hireme.leetcode.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Count_Number_Of_Teams_1395 {
    public int numTeams(int[] rating) {
        int n = rating.length;
        int count = 0;

        // Case 1: Increasing triplets
        for (int i = 0; i < n; i++) {
            int leftSmaller = 0, rightLarger = 0;
            for (int j = 0; j < i; j++) {
                if (rating[j] < rating[i]) leftSmaller++;
            }
            for (int k = i + 1; k < n; k++) {
                if (rating[k] > rating[i]) rightLarger++;
            }
            count += leftSmaller * rightLarger;
        }

        // Case 2: Decreasing triplets
        for (int i = 0; i < n; i++) {
            int leftLarger = 0, rightSmaller = 0;
            for (int j = 0; j < i; j++) {
                if (rating[j] > rating[i]) leftLarger++;
            }
            for (int k = i + 1; k < n; k++) {
                if (rating[k] < rating[i]) rightSmaller++;
            }
            count += leftLarger * rightSmaller;
        }

        return count;
    }

    public static void main(String[] args) {
        Count_Number_Of_Teams_1395 obj = new Count_Number_Of_Teams_1395();
        System.out.println(obj.numTeams(new int[]{2, 5, 3, 4, 1}));
    }


}
