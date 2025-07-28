package org.hireme.misc;

import java.util.HashSet;
import java.util.Set;

public class Maximum_Erasure_Value_1695 {
    public int maximumUniqueSubarray(int[] nums) {
        int l = 0, r = 1;
        Set<Integer> seenSet = new HashSet<>();
        seenSet.add(nums[0]);
        int currScore = nums[0], maxScore = currScore;
        while (r < nums.length) {
            if (seenSet.contains(nums[r])) {
                while (nums[l] != nums[r]) {
                    currScore -= nums[l];
                    l++;
                }
                seenSet.remove(nums[l]);
                currScore -= nums[l];
                l++;
            }

            seenSet.add(nums[r]);
            currScore += nums[r];
            if (currScore > maxScore) maxScore = currScore;
            r++;
        }

        return maxScore;
    }

    public static void main(String[] args) {
        Maximum_Erasure_Value_1695 obj = new Maximum_Erasure_Value_1695();
        System.out.println(obj.maximumUniqueSubarray(new int[]{5, 2, 1, 2, 5, 2, 1, 2, 5}));
    }
}
