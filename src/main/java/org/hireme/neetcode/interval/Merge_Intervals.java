package org.hireme.neetcode.interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Merge_Intervals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        List<int[]> result = new ArrayList<>();
        result.add(intervals[0]);
        int[] prevInterval;

        for (int i = 1; i < intervals.length; i++) {
            prevInterval = result.get(result.size() - 1);
            if (intervals[i][0] <= prevInterval[1]) {
                result.set(result.size() - 1, new int[]{Math.min(intervals[i][0], prevInterval[0]),
                        Math.max(intervals[i][1], prevInterval[1])});
            } else {
                result.add(intervals[i]);
            }
        }

        return result.toArray(new int[result.size()][2]);
    }
}
