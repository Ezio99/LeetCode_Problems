package org.hireme.leetcode.Intervals;

//Greedy
//Move events to one end of the event time range
public class Reschedule_Meetings_Max_Free_Time_3439 {
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        int numEvent = startTime.length;
        int[] gapBehind = new int[numEvent + 1];
        gapBehind[0] = startTime[0];
        int ctr = 1;
        for (int i = 1; i < numEvent; i++) {
            gapBehind[ctr++] = startTime[i] - endTime[i - 1];
        }
        gapBehind[numEvent] = eventTime - endTime[numEvent - 1];

        // Sliding window of size k + 1
        int windowSum = 0;
        for (int i = 0; i <= k && i < gapBehind.length; i++) {
            windowSum += gapBehind[i];
        }

        //Selected first k gaps
        int max = windowSum;

        // removing the leftmost gap and adding a new gap seeing if its bigger that way and so on...
        for (int i = k + 1; i < gapBehind.length; i++) {
            windowSum += gapBehind[i] - gapBehind[i - k - 1];
            max = Math.max(max, windowSum);
        }

        return max;


    }

    public static void main(String[] args) {
        Reschedule_Meetings_Max_Free_Time_3439 obj = new Reschedule_Meetings_Max_Free_Time_3439();
        System.out.println(obj.maxFreeTime(10, 1, new int[]{0, 2, 9}, new int[]{1, 4, 10}));
        System.out.println(obj.maxFreeTime(10, 1, new int[]{0, 2, 6, 9}, new int[]{1, 4, 7, 10}));
    }

    /**
     *        int ctr = 0;
     *         int start = 0, gap;
     *         while (k != 0) {
     *             if (startTime[ctr] != start) {
     *                 gap = endTime[ctr] - startTime[ctr];
     *                 startTime[ctr] = start;
     *                 endTime[ctr] = start + gap;
     *                 start = endTime[ctr];
     *                 ctr++;
     *                 k--;
     *             }
     *         }
     */
}
