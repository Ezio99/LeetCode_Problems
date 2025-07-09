package org.hireme.leetcode.Intervals;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

//Any given day I want to go to the event available on that day
//If multiple events are possible I go to the event which will end first
public class Max_Num_Events_Attend_1353 {
    public int maxEvents(int[][] events) {
        int maxDay = -1;

        Arrays.sort(events, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        for (int[] event : events) {
            maxDay = Math.max(maxDay, event[1]);
        }


        PriorityQueue<int[]> minHeap = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        int eventIndex = 0, currDay = 1, eventAttended = 0;
        while (currDay <= maxDay) {
            while (eventIndex < events.length && currDay == events[eventIndex][0]) {
                minHeap.offer(events[eventIndex]);
                eventIndex++;
            }
            while (!minHeap.isEmpty() && currDay > minHeap.peek()[1]) {
                minHeap.poll();
            }

            if (!minHeap.isEmpty() && currDay <= minHeap.peek()[1]){
                eventAttended++;
                minHeap.poll();
            }
            currDay++;

        }

        return eventAttended;

    }

    public static void main(String[] args) {
        Max_Num_Events_Attend_1353 obj = new Max_Num_Events_Attend_1353();
        System.out.println(obj.maxEvents(new int[][]{
                {1, 2},
                {2, 3},
                {3, 4},
                {1, 2},
        }));
    }
}
