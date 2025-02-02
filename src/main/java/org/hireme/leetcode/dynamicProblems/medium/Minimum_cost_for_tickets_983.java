package org.hireme.leetcode.dynamicProblems.medium;

public class Minimum_cost_for_tickets_983 {
    public int mincostTickets(int[] days, int[] costs) {
        int[] cache = new int[days.length];
        return recursiveHelper(days, costs, 0, cache);
    }

    private int bottomUpHelper(int[] days, int[] costs) {
        int lastDay = days[days.length - 1];
        int[] dp = new int[lastDay + 1];
        boolean[] travelDays = new boolean[lastDay + 1];


        for (int day : days) {
            travelDays[day] = true;
        }


        for (int i = 1; i <= lastDay; i++) {
            if (!travelDays[i]) {
                dp[i] = dp[i - 1]; // No travel cost for this day
            } else {
                dp[i] = Math.min(
                        dp[i - 1] + costs[0], // 1-day ticket
                        Math.min(
                                dp[Math.max(0, i - 7)] + costs[1], // 7-day ticket
                                dp[Math.max(0, i - 30)] + costs[2] // 30-day ticket
                        )
                );
            }
        }

        return dp[lastDay];

    }

    private int recursiveHelper(int[] days, int[] costs, int dayIndex, int[] cache) {
        if (dayIndex >= days.length) {
            return 0;
        }
        if (cache[dayIndex] != 0) {
            return cache[dayIndex];
        }

        int day1Ticket, day7Ticket, day30Ticket;

        //Choice of buying 1-day ticket today
        day1Ticket = costs[0] + recursiveHelper(days, costs, dayIndex + 1, cache);

        //Choice of buying 7-day ticket today
        day7Ticket = costs[1] + recursiveHelper(days, costs, indexOfXDaysLater(dayIndex, days, 7), cache);

        //Choice of buying 30-day ticket today
        day30Ticket = costs[2] + recursiveHelper(days, costs, indexOfXDaysLater(dayIndex, days, 30), cache);

        cache[dayIndex] = Math.min(Math.min(day1Ticket, day7Ticket), day30Ticket);

        return cache[dayIndex];

    }

    private int indexOfXDaysLater(int current, int[] days, int x) {
        for (int i = current + 1; i < days.length; i++) {
            if (days[i] - days[current] >= x) {
                return i;
            }
        }
        return days.length;
    }

    public static void main(String[] args) {
        Minimum_cost_for_tickets_983 obj = new Minimum_cost_for_tickets_983();
        System.out.println(obj.mincostTickets(new int[]{1, 4, 6, 7, 8, 20}, new int[]{2, 7, 15}));
        System.out.println(obj.mincostTickets(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 30, 31}, new int[]{2, 7, 15}));
    }


}
