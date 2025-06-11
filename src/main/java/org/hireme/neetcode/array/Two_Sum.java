package org.hireme.neetcode.array;

import java.util.HashMap;

public class Two_Sum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> valuetoIndex = new HashMap<>();
        int diff;
        for (int i = 0; i < nums.length; i++) {
            diff = target - nums[i];
            if (valuetoIndex.containsKey(diff)) {
                return new int[]{valuetoIndex.get(diff), i};
            }
            valuetoIndex.put(nums[i], i);
        }

        return new int[]{};
    }
}
