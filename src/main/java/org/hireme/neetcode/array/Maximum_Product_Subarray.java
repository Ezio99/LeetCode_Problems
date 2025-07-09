package org.hireme.neetcode.array;

public class Maximum_Product_Subarray {

    public int maxProduct(int[] nums) {
        int currMax = nums[0], currMin = nums[0], result = nums[0];
        int tmpMax;

        //At each stage we need to track max and min to make optimal choice
        // We need min because in case of encountering a -ve the min becomes max and vice versa
        for (int i = 1; i < nums.length; i++) {
            tmpMax = currMax;
            currMax = Math.max(nums[i], Math.max(nums[i] * currMax, nums[i] * currMin));
            currMin = Math.min(nums[i], Math.min(nums[i] * tmpMax, nums[i] * currMin));

            result = Math.max(currMax, result);
        }

        return result;
    }


    public static void main(String[] args) {
        Maximum_Product_Subarray obj = new Maximum_Product_Subarray();
        System.out.println(obj.maxProduct(new int[]{-2, 3, -4}));
    }

//    public int dfs(int i, int[] nums) {
//        if (i >= nums.length) {
//            return 1;
//        }
//
//        int p = nums[i];
//        for (int j = i + 1; j < nums.length; j++) {
//            if (nums[j] > 0) {
//                p *= nums[j];
//            } else if (nums[j] < 0) {
//                p = Math.max(p * dfs(j, nums), dfs(j, nums));
//                break;
//            } else {
//                p = Math.max(p, dfs(j, nums));
//                break;
//            }
//        }
//
//        return p;
//    }
}
