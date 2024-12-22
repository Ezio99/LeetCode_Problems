package org.hireme.neetcode.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    public static List<List<Integer>> subsets(int[] nums) {
        List<Integer> curr = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();

        helper(0, nums, curr, result);

        return result;
    }

    public static void helper(int i, int[] nums, List<Integer> curr, List<List<Integer>> result) {
        if (i == nums.length) {
            result.add(new ArrayList<>(curr));
            return;
        }

        curr.add(nums[i]);
        helper(i + 1, nums, curr, result);

        curr.removeLast();
        helper(i + 1, nums, curr, result);


    }

    public static void main(String[] args) {
        int[] values = {1, 2, 3};
        System.out.println(subsets(values));
    }


}
