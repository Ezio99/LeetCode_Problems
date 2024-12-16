package org.hireme.misc;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Final_Array_State_1_3264 {

    public static int[] getFinalState(int[] nums, int k, int multiplier) {
        if (nums.length==0){
            return nums;
        }

        if(nums.length==1){
            nums[0]*= (int) Math.pow(multiplier,k);
            return nums;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            if(o1[1]==o2[1]){
                return o1[0]-o2[0];
            }
            return o1[1]-o2[1];
        });

        for(int i = 0; i < nums.length ; i++){
            pq.add(new int[]{i,nums[i]});
        }

        //This pq approach uses a K*logN TC
        for (int i = 0; i < k ; i++) {
            int[] x = pq.poll();
            nums[x[0]]*=multiplier;
            x[1]*=multiplier;
            pq.add(x);
        }

        //This linear scan method is K*N
//        for (int i = 0; i < k ; i++) {
//            int minIndex = 0;
//
//            // Find the index of the minimum element
//            for (int j = 1; j < nums.length; j++) {
//                if (nums[j] < nums[minIndex]) {
//                    minIndex = j;
//                }
//            }
//
//            // Multiply the smallest element by the multiplier
//            nums[minIndex] *= multiplier;
//        }


// TODO: Usually you'd think that the PQ approach is better due to logN time complexity but remember that all logN does
// is make it grow slowly, but in small N cases the overhead of PQ might cause the runtime to increase as compared to the linear case

        return nums;



    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,1,3,5,6};
        int k =5,multiplier = 2;
        System.out.println(Arrays.toString(getFinalState(nums, k, multiplier)));
    }
}
