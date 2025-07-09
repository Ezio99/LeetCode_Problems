package org.hireme.misc;

import java.util.HashMap;

public class Longest_Harmonious_Subsequence_594 {

    public int findLHSSinglePass(int[] nums) {
        int maxCount = 0;
        HashMap<Integer, Integer> frequency = new HashMap<>();

        for (int i : nums) {
            frequency.merge(i, 1, Integer::sum);
            if (frequency.containsKey(i + 1)) {
                maxCount = Math.max(maxCount, frequency.get(i) + frequency.get(i + 1));
            }
            if (frequency.containsKey(i - 1)) {
                maxCount = Math.max(maxCount, frequency.get(i) + frequency.get(i - 1));
            }

        }

        return maxCount;

    }

//    [1, 2, 2, 2, 3, 3, 5, 7]


    //Faster
    public int findLHS(int[] nums) {
        HashMap<Integer, Integer> frequency = new HashMap<>();
        for (int i : nums) {
            frequency.merge(i, 1, Integer::sum);
        }

        int maxCount = 0;

        for (int key : frequency.keySet()) {
            if (frequency.containsKey(key + 1)) {
                maxCount = Math.max(maxCount, frequency.get(key) + frequency.get(key + 1));
            }
        }

        return maxCount;
    }

    public static void main(String[] args) {
        Longest_Harmonious_Subsequence_594 obj = new Longest_Harmonious_Subsequence_594();
        System.out.println(obj.findLHSSinglePass(new int[]{1, 3, 2, 2, 5, 2, 3, 7}));
    }
}
