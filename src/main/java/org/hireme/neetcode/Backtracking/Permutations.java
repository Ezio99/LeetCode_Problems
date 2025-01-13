package org.hireme.neetcode.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    public static List<List<Integer>> permute(int[] nums) {
        return helper(nums);
    }

    private static List<List<Integer>> helper( int[] nums) {
        List<List<Integer>> perms = new ArrayList<>();
        perms.add(new ArrayList<>());
        int i=0;


        while (i < nums.length) {
            List<List<Integer>> nextPerms = new ArrayList<>();
            for (int j = 0; j < perms.size(); j++) {
                List<Integer> perm = perms.get(j);
                for (int k = 0; k < perm.size() + 1; k++) {
                    List<Integer> copy = new ArrayList<>(perm);
                    copy.add(k, nums[i]);
                    nextPerms.add(copy);
                }
            }
            perms = nextPerms;
            i++;
        }

        return perms;
    }

    public static void main(String[] args) {
        System.out.println(permute(new int[]{1, 2, 3}));
    }
}
