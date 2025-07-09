package org.hireme.neetcode.twopointer;

import java.util.*;


//Use 2 pointer approach
public class Three_sum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currResult;
        int i = 0, j;
        int diff;
        while (i < nums.length) {
            HashSet<Integer> vals = new HashSet<>();
            j = i + 1;
            while (j < nums.length) {
                diff = -1 * (nums[i] + nums[j]);
                if (vals.contains(diff)) {
                    currResult = new ArrayList<>();
                    currResult.add(nums[i]);
                    currResult.add(nums[j]);
                    currResult.add(diff);
                    result.add(currResult);
                    vals.add(nums[j]);
                    do {
                        j++;
                    } while (j < nums.length && nums[j - 1] == nums[j]);
                    continue;
                }
                vals.add(nums[j]);
                j++;
            }
            do {
                i++;
            } while (i < nums.length && nums[i - 1] == nums[i]);

        }

        return result;

    }

    public static void main(String[] args) {
        Three_sum obj = new Three_sum();
        System.out.println(obj.threeSum(new int[]{0, 0, 0, 0}));
        System.out.println(obj.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }
}
