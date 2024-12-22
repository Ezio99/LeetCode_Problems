package org.hireme.neetcode.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Has repeated values
public class Subsets_2 {

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<Integer> curr = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        helper_2(0, nums, curr, result);

        return result;
    }

    public static void helper_2(int i, int[] nums, List<Integer> curr, List<List<Integer>> result) {
        if (i >= nums.length) {
            result.add(new ArrayList<>(curr));
            return;
        }


        curr.add(nums[i]);
        helper_2(i + 1, nums, curr, result);

        curr.removeLast();
        while (i < nums.length - 1) {
            if (nums[i] == nums[i + 1]) {
                i++;
            } else {
                break;
            }

        }
        helper_2(i + 1, nums, curr, result);


    }

    public static void main(String[] args) {
//        int[] values = {1, 2, 3};
        int[] values = {1, 2, 3, 2};
        System.out.println(subsetsWithDup(values));
    }
}
