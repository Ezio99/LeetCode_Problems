package org.hireme.misc;

public class Max_Unique_SubArray_Sum_Deletion_3487 {
    public int maxSum(int[] nums) {
        int[] counts = new int[201];
        int sum = 0;

        for (int num : nums) counts[num + 100]++;

        for (int i = 100; i > 0; i--) sum += counts[i + 100] > 0 ? i : 0;

        if (sum > 0) return sum;

        for (int i = 0; i >= -100; i--) if (counts[i + 100] > 0) return i;

        return 0;
    }

    public static void main(String[] args) {
        Max_Unique_SubArray_Sum_Deletion_3487 obj = new Max_Unique_SubArray_Sum_Deletion_3487();
        System.out.println(obj.maxSum(new int[]{1, 2, -1, -2, 1, 0, -1}));
        System.out.println(obj.maxSum(new int[]{1, 2, 3, 4, 5}));
        System.out.println(obj.maxSum(new int[]{100, -100}));
        System.out.println(obj.maxSum(new int[]{-100}));
    }
}
