package org.hireme.misc;

import java.util.Arrays;

public class Maximum_Matching_Players_Trainers_2410 {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);

        int plCtr = 0, trCtr = 0;
        while (plCtr < players.length && trCtr < trainers.length) {
            if (players[plCtr] <= trainers[trCtr]) {
                plCtr++;
            }
            trCtr++;
        }

        return plCtr;
    }

    public static void main(String[] args) {
        Maximum_Matching_Players_Trainers_2410 obj = new Maximum_Matching_Players_Trainers_2410();
        System.out.println(obj.matchPlayersAndTrainers(new int[]{4, 7, 9}, new int[]{8, 2, 5, 8}));
    }
}
