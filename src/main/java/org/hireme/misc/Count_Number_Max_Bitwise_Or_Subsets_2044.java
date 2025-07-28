package org.hireme.misc;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Count_Number_Max_Bitwise_Or_Subsets_2044 {
    int max;

    public int countMaxOrSubsets(int[] nums) {
        int maxVal = 0;
        for (int num : nums) {
            maxVal |= num;
        }
        max = maxVal;
        Integer[][] cache = new Integer[nums.length][maxVal + 1];

        return dfs(0, 0, nums, cache);
    }

    public int dfs(int i, int score, int[] nums, Integer[][] cache) {
        if (i == nums.length) {
            if (score == max) {
                return 1;
            }
            return 0;
        }
        if (cache[i][score] != null) {
            return cache[i][score];
        }

        cache[i][score] = dfs(i + 1, score | nums[i], nums, cache) + dfs(i + 1, score, nums, cache);

        return cache[i][score];
    }

    public static void main(String[] args) {
        Count_Number_Max_Bitwise_Or_Subsets_2044 obj = new Count_Number_Max_Bitwise_Or_Subsets_2044();
        System.out.println(obj.countMaxOrSubsets(new int[]{3, 1}));
        System.out.println(obj.countMaxOrSubsets(new int[]{2, 2, 2}));
        System.out.println(obj.countMaxOrSubsets(new int[]{3, 2, 1, 5}));
        System.out.println(obj.countMaxOrSubsets(new int[]{3, 2, 1, 6, 8, 9, 20, 3}));
    }
}
