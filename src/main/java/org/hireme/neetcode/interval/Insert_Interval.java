package org.hireme.neetcode.interval;

import java.util.ArrayList;
import java.util.List;

public class Insert_Interval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int n = intervals.length, i = 0;

        //Find place where new interval will come before or overlap with interval
        while (i < n && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }

        //If it is overlapping then keep merging while overlap exists
        while (i < n && newInterval[1] >= intervals[i][0]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }

        result.add(newInterval);

        //Ad rest of the intervals
        while(i<n){
            result.add(intervals[i++]);
        }

        return result.toArray(new int[result.size()][2]);
    }
}
