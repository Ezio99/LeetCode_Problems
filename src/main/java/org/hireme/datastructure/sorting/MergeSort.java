package org.hireme.datastructure.sorting;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MergeSort {

    public List<Pair> mergeSort(List<Pair> pairs) {
        if (pairs.isEmpty()) {
            return pairs;
        }
        return divide(0, pairs.size() - 1, pairs);
    }

    public List<Pair> divide(int l, int r, List<Pair> pairs) {
        if (r > l) {
            int m = l + (r - l) / 2;
            divide(l, m, pairs);
            divide(m + 1, r, pairs);
            merge(l, m, r, pairs);
        }

        return pairs;

    }

    public void merge(int l, int m, int r, List<Pair> pairs) {

        List<Pair> leftPair = new ArrayList<>(pairs.subList(l, m + 1));
        List<Pair> rightPair = new ArrayList<>(pairs.subList(m + 1, r + 1));

        int lp = 0, rp = 0, ctr = l;
        while (lp < leftPair.size() && rp < rightPair.size()) {
            if (leftPair.get(lp).key <= rightPair.get(rp).key) {
                pairs.set(ctr, leftPair.get(lp++));
            } else {
                pairs.set(ctr, rightPair.get(rp++));
            }
            ctr++;
        }

        while (lp < leftPair.size()) {
            pairs.set(ctr++, leftPair.get(lp++));
        }

        while (rp < rightPair.size()) {
            pairs.set(ctr++, rightPair.get(rp++));
        }

//        return pairs;
    }

    public static class Pair {
        public int key;
        public String value;

        public Pair(int key, String value) {
            this.key = key;
            this.value = value;
        }
    }
}
