package org.hireme.dynamicProblems.medium;

import java.util.HashMap;
import java.util.Stack;

public class Jump_Game_53 {

    public static Stack<Integer> stack = new Stack<>();
    public static HashMap<Integer,Boolean> indexVisted = new HashMap<>();
    public  static  int currentIndex=0;

    static {
        stack.add(currentIndex);
        indexVisted.put(currentIndex,false);
    }

    public static boolean canJump(int[] nums) {
        if(stack.empty()){
            return false;
        }
        currentIndex = stack.pop();
        indexVisted.put(currentIndex,true);
        if(currentIndex+nums[currentIndex]>=nums.length-1){
            return true;
        }
        for(int i=1;i<=nums[currentIndex];i++){
            if(indexVisted.get(currentIndex+i)==null){
                stack.add(currentIndex+i);
                indexVisted.put(currentIndex+i,false);
            }

        }
        return canJump(nums);

    }

    public static void main(String[] args){
        System.out.println(canJump(new int[]{3,2,1,0,4}));
        System.out.println(canJump(new int[]{2,3,1,1,4}));
    }
}
