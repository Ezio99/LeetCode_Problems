package org.hireme.misc;

public class Max_Num_Ops_Same_Score_1 {
    public int maxOperations(int[] nums) {
        int i = 2, initialScore = nums[0] + nums[1], ctr = 1;
        while (i <= nums.length - 2) {
            if(nums[i] + nums[i + 1]!=initialScore){
                break;
            }
            i += 2;
            ctr++;
        }
        return ctr;
    }
}
