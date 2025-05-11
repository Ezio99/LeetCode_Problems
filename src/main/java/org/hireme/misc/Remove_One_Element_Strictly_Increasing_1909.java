package org.hireme.misc;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Remove_One_Element_Strictly_Increasing_1909 {
    public boolean canBeIncreasing(int[] nums) {
        int chance = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] >= nums[i]) {
                if (chance == 1) {
                    if (i > 1 && nums[i - 2] >= nums[i]) {
                        nums[i] = nums[i - 1];
                    }
                }
                chance--;
            }
        }
        return chance >= 0;
    }


    public static void main(String[] args) {
        Remove_One_Element_Strictly_Increasing_1909 obj = new Remove_One_Element_Strictly_Increasing_1909();
        System.out.println(obj.canBeIncreasing(new int[]{1, 1, 1}));
        System.out.println(obj.canBeIncreasing(new int[]{1, 2, 10, 5, 7}));
    }
}
