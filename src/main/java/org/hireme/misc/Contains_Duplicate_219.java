package org.hireme.misc;

import java.util.HashMap;
import java.util.HashSet;

public class Contains_Duplicate_219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> latestIndex = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (latestIndex.containsKey(nums[i])) {
                if (Math.abs(latestIndex.get(nums[i]) - i) <= k) {
                    return true;
                }
            }
            latestIndex.put(nums[i], i);
        }
        return false;
    }

    public boolean containsNearbyDuplicateSlide(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();

        int l = 0;

        for (int r = 0; r < nums.length; r++) {
            if (!set.add(nums[r])) {
                return true;
            }

            if (r - l== k) {
                set.remove(nums[l]);
                l++;
            }
        }
        return false;
    }
}
