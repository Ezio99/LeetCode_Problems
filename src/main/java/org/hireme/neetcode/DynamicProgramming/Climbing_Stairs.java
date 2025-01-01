package org.hireme.neetcode.DynamicProgramming;

import java.util.HashMap;

public class Climbing_Stairs {
    public static int climbStairs(int n) {
        HashMap<Integer,Integer> cache = new HashMap<>();
        cache.put(1,1);
        cache.put(0,1);
        return helper(n,cache);

    }

    public static int helper( int n, HashMap<Integer, Integer> cache) {
        if(n<0){
            return 0;
        }
        if (cache.get(n) != null) {
            return cache.get(n);
        }

        cache.put(n,helper(n-1, cache) + helper( n-2, cache));
        return cache.get(n);
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(3));
    }

}
