package org.hireme.misc;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Find_All_K_Distance_Index_2200 {
    public List<Integer> findKDistantIndicesOptimal(int[] nums, int key, int k) {
        List<Integer> result = new ArrayList<>();
        int left, right = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == key) {
                left = Math.max(right, i - k);
                right = Math.min(nums.length - 1, i + k);
                for (int j = left; j <= right; j++) {
                    result.add(j);
                }
            }
        }

        return result;
    }

    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        int[] keyIndexes = new int[nums.length];
        int ctr = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == key) {
                keyIndexes[ctr++] = i;
            }
        }

        if (ctr == 0) return new ArrayList<>();
        List<Integer> result = new ArrayList<>();

        int curr = 0, dist, i = 0;
        while (i < nums.length) {
            dist = Math.abs(i - keyIndexes[curr]);
            if (dist <= k) {
                result.add(i);
            } else if (i > keyIndexes[curr]) {
                curr++;
                if (curr == ctr) break;
                continue;
            }
            i++;
        }

        return result;
    }

    public static void main(String[] args) {
        Find_All_K_Distance_Index_2200 obj = new Find_All_K_Distance_Index_2200();
        System.out.println(obj.findKDistantIndicesOptimal(new int[]{3, 4, 9, 1, 3, 9, 5}, 9, 1));
    }
}
