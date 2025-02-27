package org.hireme.leetcode.dynamicProblems.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Triangle_120 {

    public int minimumTotal(List<List<Integer>> triangle) {
//        return dfsHelper(0, 0, triangle);
//        int[][] cache = new int[triangle.size()][triangle.getLast().size()];
//        for (int i = 0; i < triangle.size(); i++) {
//            Arrays.fill(cache[i], -1);
//        }
//
//        return topDownHelper(0, 0, triangle, cache);
        return bottomUpHelper(triangle);
    }

    //For each element of each level pick the minimum possible element from the level below
    private int bottomUpHelper(List<List<Integer>> triangle) {
        List<Integer> curr = new ArrayList<>(triangle.getLast());

        for (int i = triangle.size() - 2; i >= 0; i--) {
            List<Integer> res = new ArrayList<>();
            for (int j = 0; j < triangle.get(i).size(); j++) {
                res.add(triangle.get(i).get(j) + Math.min(curr.get(j), curr.get(j + 1)));
            }
            curr = res;
        }

        return curr.get(0);
    }

    private int topDownHelper(int i, int j, List<List<Integer>> triangle, int[][] cache) {
        //Reached the destination (last level) return the value
        if (i >= triangle.size()) {
            return 0;
        }
        //Dont want out of bounds to return as a valid answer
        if (j >= triangle.get(i).size()) {
            return Integer.MAX_VALUE;
        }
        if (cache[i][j] != -1) {
            return cache[i][j];
        }


        cache[i][j] = triangle.get(i).get(j) + Math.min(topDownHelper(i + 1, j, triangle, cache)
                , topDownHelper(i + 1, j + 1, triangle, cache));

        return cache[i][j];
    }

    private int dfsHelper(int i, int j, List<List<Integer>> triangle) {
        if (i >= triangle.size()) {
            return 0;
        }
        if (j >= triangle.get(i).size()) {
            return Integer.MAX_VALUE;
        }

        return triangle.get(i).get(j) + Math.min(dfsHelper(i + 1, j, triangle), dfsHelper(i + 1, j + 1, triangle));

    }

    public static void main(String[] args) {
        Triangle_120 obj = new Triangle_120();
        List<List<Integer>> list = new ArrayList<>();
        list.add(Arrays.asList(2));
        list.add(Arrays.asList(3, 4));
        list.add(Arrays.asList(6, 5, 7));
        list.add(Arrays.asList(4, 1, 8, 3));

        System.out.println(obj.minimumTotal(list));


    }


}
