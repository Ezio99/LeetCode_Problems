package org.hireme.leetcode.Intervals;

import java.util.Arrays;
import java.util.Comparator;

public class Max_Num_Events_Attend_2_1751 {

    public int maxValue(int[][] events, int k) {
        Arrays.sort(events, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });


        int[][] cache = new int[events.length][k + 1];

        for (int i = 0; i < events.length; i++) {
            Arrays.fill(cache[i], -1);
        }

//        return dfs(0, events[0][0], events, k, cache);
        return topDown(0, k, events, cache);
    }

    public int topDown(int i, int k, int[][] events, int[][] cache) {
        if (i == events.length || k == 0) return 0;

        if (cache[i][k] != -1) return cache[i][k];

        int skip = topDown(i + 1, k, events, cache);
        int nextIndex = findNext(events, i + 1, events[i][1] + 1);
        int take = events[i][2] + topDown(nextIndex, k - 1, events, cache);

        return cache[i][k] = Math.max(take, skip);
    }


    //Binary search to find next available event by day
    public int findNext(int[][] events, int low, int targetEnd) {
        int high = events.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (events[mid][0] >= targetEnd) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        Max_Num_Events_Attend_2_1751 obj = new Max_Num_Events_Attend_2_1751();
        System.out.println(obj.maxValue(new int[][]{
                {1, 2, 4},
                {3, 4, 3},
                {2, 3, 1},
        }, 2));
        System.out.println(obj.maxValue(new int[][]{
                {1, 2, 4},
                {3, 4, 3},
                {2, 3, 10},
        }, 2));
        System.out.println(obj.maxValue(new int[][]{
                {1, 1, 1},
                {2, 2, 2},
                {3, 3, 3},
                {4, 4, 4},
        }, 3));
    }

//    public int dfs(int i, int day, int[][] events, int k, int[][] cache) {
//        if (k == 0 || i >= events.length || day > maxDay) {
//            return 0;
//        }
//        if (cache[i][k] != -1) {
//            return cache[i][k];
//        }
//
//        int ignore = 0, take = 0, max = 0;
//
//
//        for (int j = i; j < events.length; j++) {
//            if (events[j][0] >= day) {
//                take = Math.max(take, events[j][2] + dfs(j + 1, events[j][1] + 1, events, k - 1, cache));
//                ignore = dfs(j + 1, day, events, k, cache);
//                max = Math.max(max, Math.max(take, ignore));
//            }
//
//        }
//
//        cache[i][k] = max;
//        return max;
//
//
//    }
}
