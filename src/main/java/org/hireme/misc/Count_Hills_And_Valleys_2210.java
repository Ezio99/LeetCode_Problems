package org.hireme.misc;

public class Count_Hills_And_Valleys_2210 {
    public int countHillValley(int[] nums) {
        int mid = 1, right, ctr = 0;
        while (mid < nums.length - 1) {
            //If mid is equal to left then go to next index
            if (nums[mid - 1] == nums[mid]) {
                mid++;
                continue;
            }
            right = mid + 1;
            //If right is equal to mid, skip until next non-equal value
            if (nums[right] == nums[mid]) {
                while (right < nums.length && nums[right] == nums[mid]) {
                    right++;
                }
                //If no non-equal value found until end, break out of outer loop
                if (right >= nums.length) break;
            }

            if ((nums[mid] > nums[mid - 1] && nums[mid] > nums[right]) || (nums[mid] < nums[mid - 1] && nums[mid] < nums[right])) {
                ctr++;
            }
            //Move mid to next non equal value
            mid = right;
        }

        return ctr;
    }

    public static void main(String[] args) {
        Count_Hills_And_Valleys_2210 obj = new Count_Hills_And_Valleys_2210();
        System.out.println(obj.countHillValley(new int[]{6, 6, 5, 5, 4, 1}));
        System.out.println(obj.countHillValley(new int[]{2, 4, 1, 1, 6, 5}));
    }
}
