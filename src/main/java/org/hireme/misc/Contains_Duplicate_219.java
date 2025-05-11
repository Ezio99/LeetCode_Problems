package org.hireme.misc;

import java.util.HashMap;

public class Contains_Duplicate_219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> latestIndex = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (latestIndex.containsKey(nums[i])) {
                if (Math.abs(latestIndex.get(nums[i]) - i) <= k) {
                    return true;
                }
            }
            latestIndex.put(nums[i],i);
        }
        return false;
    }
}
