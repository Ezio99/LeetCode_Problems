package org.hireme.leetcode.backtrack;

import java.util.ArrayList;
import java.util.List;

public class Combinations_77 {


    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> results = new ArrayList<>();
//        unOptimizedHelper(1, n, k, results, new ArrayList<>());
        optimizedHelper(1, n, k, results, new ArrayList<>());
        return results;
    }

    //Unoptimized way
    private static void unOptimizedHelper(int i, int n, int k, List<List<Integer>> results, List<Integer> currentCombination) {
        if (currentCombination.size() == k) {
            results.add(new ArrayList<>(currentCombination));
            return;
        }
        if (i > n) {
            return;
        }

        currentCombination.add(i);
        unOptimizedHelper(i + 1, n, k, results, currentCombination);

        currentCombination.removeLast();
        unOptimizedHelper(i + 1, n, k, results, currentCombination);

    }

    private static void optimizedHelper(int i, int n, int k, List<List<Integer>> results, List<Integer> currentCombination) {
        if (currentCombination.size() == k) {
            results.add(new ArrayList<>(currentCombination));
            return;
        }

        while (i <= n) {
            currentCombination.add(i);
            optimizedHelper(i + 1, n, k, results, currentCombination);
            currentCombination.removeLast();
            i++;
        }

    }

    public static void main(String[] args) {
        System.out.println(combine(5, 2));
    }
}
