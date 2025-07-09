package org.hireme.misc;

import java.util.HashMap;

class Find_Pairs_Sum_1865 {

    int[] nums1;
    int[] nums2;
    HashMap<Integer, Integer> frequency1;
    HashMap<Integer, Integer> frequency2;

    public Find_Pairs_Sum_1865(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2;

        frequency1 = new HashMap<>();
        frequency2 = new HashMap<>();

        for (int i : nums1) {
            frequency1.merge(i, 1, Integer::sum);
        }

        for (int i : nums2) {
            frequency2.merge(i, 1, Integer::sum);
        }
    }

    public void add(int index, int val) {
        frequency2.merge(nums2[index], -1, Integer::sum);
        nums2[index] += val;
        frequency2.merge(nums2[index], 1, Integer::sum);
    }

    public int count(int tot) {
        int ctr = 0;
        int requiredNumber;
        for (int num : frequency1.keySet()) {
            requiredNumber = tot - num;
            if (frequency2.containsKey(requiredNumber) && frequency2.get(requiredNumber) > 0) {
                ctr += frequency1.get(num) * frequency2.get(requiredNumber);
            }
        }

        return ctr;
    }

    public static void main(String[] args) {
        Find_Pairs_Sum_1865 obj = new Find_Pairs_Sum_1865(new int[]{1, 1, 2, 2, 2, 3}, new int[]{1, 4, 5, 2, 5, 4});
        System.out.println(obj.count(7));
        obj.add(3, 2);
        System.out.println(obj.count(8));
    }
}




