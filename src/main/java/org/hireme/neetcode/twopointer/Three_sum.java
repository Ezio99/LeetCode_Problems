package org.hireme.neetcode.twopointer;

import java.util.*;

public class Three_sum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int i = 0, sum;
        int l, r;
        while (i < nums.length - 1) {
            l = i + 1;
            r = nums.length - 1;
            while (l < r) {
                sum = nums[i] + nums[l] + nums[r];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    l++;
                    r--;
                } else if (sum > 0) {
                    r--;
                } else {
                    l++;
                }
            }
        }


        return result;
    }

    public static void main(String[] args) {
        Three_sum obj = new Three_sum();
        System.out.println(obj.threeSum(new int[]{0, 0, 0, 0}));
    }
}
