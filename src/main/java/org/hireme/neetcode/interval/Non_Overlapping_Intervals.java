package org.hireme.neetcode.interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

//Remove bigger interval - No
//Keep interval with smaller end
public class Non_Overlapping_Intervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        List<int[]> netInterval = new ArrayList<>();
        netInterval.add(intervals[0]);


        for (int i = 1; i < n; i++) {
            if (intervals[i][0] < netInterval.get(netInterval.size() - 1)[1]) {
                if (netInterval.get(netInterval.size() - 1)[1] > intervals[i][1]) {
                    netInterval.set(netInterval.size() - 1, intervals[i]);
                }
                continue;
            }
            netInterval.add(intervals[i]);
        }

        return intervals.length - netInterval.size();


    }
}
