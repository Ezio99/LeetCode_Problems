package org.hireme.misc;

import java.util.Arrays;

public class SubSequence_Min_Max_Sum_1498 {

    private static final int MOD = 1_000_000_007;

    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int result = 0;

        int[] pow2 = new int[nums.length];
        pow2[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            pow2[i] = (pow2[i - 1] * 2) % MOD;
        }

        int left = 0, right = nums.length - 1;
        while (left <= right) {
            if (nums[left] + nums[right] <= target) {
                result = (result + pow2[right - left]) % MOD;
                left++;
            } else {
                right--;
            }
        }


        return result;
    }

    public static void main(String[] args) {
        SubSequence_Min_Max_Sum_1498 obj = new SubSequence_Min_Max_Sum_1498();
        System.out.println(obj.numSubseq(new int[]{3, 5, 6, 7}, 9));
        System.out.println(obj.numSubseq(new int[]{3, 3, 6, 8}, 10));
        System.out.println(obj.numSubseq(new int[]{2, 3, 3, 4, 6, 7}, 12));
    }


    //Linear search
//            for (int i = 0; i < nums.length; i++) {
//            if (nums[i] + nums[i] > target) break;
//            j = i + 1;
//            for (; j < upperbound; j++) {
//                if (nums[i] + nums[j] > target) break;
//            }
//            upperbound = j;
//            result = (result + pow2[j - i - 1]) % MOD;
//        }


    //Binary
//    int right = nums.length - 1, left, mid, valid;
//        for (int i = 0; i < nums.length; i++) {
//        if (nums[i] *2 > target) break;
//        left = i;
//        valid = i - 1;
//        while (left <= right) {
//            mid = left + (right - left) / 2;
//            if (nums[i] + nums[mid] <= target) {
//                valid = mid; //valid till here
//                left = mid + 1;
//            } else {
//                right = mid - 1;
//            }
//        }
//
//        if (valid >= i) {
//            result = (result + pow2[valid - i]) % MOD;
//        }
//        right = valid;
//
//
//    }

}
