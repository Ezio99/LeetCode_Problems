package org.hireme.neetcode.interval;

import java.util.*;

// Basically we need to track how many max overlapping intervals are there
// To do that we just need to track how many active meetings are going on
//Every time a meeting starts we increase the count and subtract when it ends
// The max number of meetings overlapping is the number of rooms needed
public class Meeting_Rooms_2 {
    public int minMeetingRooms(List<Interval> intervals) {
        if (intervals.isEmpty()) return 0;
        int n = intervals.size();
        int[] start = new int[n];
        int[] end = new int[n];
        int ctr = 0, count = 0;
        for (Interval interval : intervals) {
            start[ctr] = interval.start;
            end[ctr] = interval.end;
            ctr++;
        }

        Arrays.sort(start);
        Arrays.sort(end);
        int minRooms = Integer.MIN_VALUE;
        int startIndex = 0, endIndex = 0;
        // When no more starts left all we'll do is decrease count
        // And start is guaranteed to finish earlier as it has lower values
        while (startIndex < n) {
            if (start[startIndex] < end[endIndex]) {
                count++;
                startIndex++;
            } else {
                count--;
                endIndex++;
            }

            if (count > minRooms) {
                minRooms = count;
            }
        }

        return minRooms;
    }

    public static void main(String[] args) {
        Meeting_Rooms_2 obj = new Meeting_Rooms_2();
        List<Interval> list = new ArrayList<>();
        list.add(new Interval(0, 40));
        list.add(new Interval(5, 10));
        list.add(new Interval(15, 20));
        System.out.println(obj.minMeetingRooms(list));
    }
}
