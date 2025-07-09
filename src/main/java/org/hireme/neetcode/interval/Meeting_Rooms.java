package org.hireme.neetcode.interval;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Meeting_Rooms {

    public boolean canAttendMeetings(List<Interval> intervals) {
        intervals.sort(new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });

        for (int i = 1; i < intervals.size(); i++) {
            if (intervals.get(i).start<intervals.get(i-1).end){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Meeting_Rooms obj = new Meeting_Rooms();
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(0, 30));
        intervals.add(new Interval(5, 10));
        intervals.add(new Interval(15, 20));

        System.out.println(obj.canAttendMeetings(intervals));

    }
}
