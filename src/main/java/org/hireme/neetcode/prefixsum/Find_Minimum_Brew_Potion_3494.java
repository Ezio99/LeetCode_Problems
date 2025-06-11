package org.hireme.neetcode.prefixsum;

public class Find_Minimum_Brew_Potion_3494 {
    public long minTime(int[] skill, int[] mana) {
        int numWiz = skill.length, numPotion = mana.length;
        //End time
        long[] finishTimes = new long[numWiz];
        finishTimes[0] = (long) skill[0] * mana[0];
        int sumskill = skill[0];
        for (int i = 1; i < numWiz; i++) {
            finishTimes[i] = ((long) skill[i] * mana[0]) + finishTimes[i - 1];
            sumskill += skill[i];
        }


        for (int i = 1; i < numPotion; i++) {
            long[] start = new long[numWiz];

            start[numWiz - 1] = finishTimes[numWiz - 1];
            for (int j = numWiz - 2; j >= 0; j--) {
                long stillBusy = finishTimes[j];
                long leaveRoom = start[j + 1] - ((long) skill[j] * mana[i]);
                start[j] = Math.max(stillBusy, leaveRoom);
            }

            finishTimes[0] = start[0]+ ((long) skill[0] * mana[i]);
            for (int j = 1; j < numWiz; j++) {
                finishTimes[j] = finishTimes[j-1] + ((long) skill[j] *mana[i]);
            }

        }

        return finishTimes[numWiz - 1];

    }

    public static void main(String[] args) {
        Find_Minimum_Brew_Potion_3494 obj = new Find_Minimum_Brew_Potion_3494();
        System.out.println(obj.minTime(new int[]{1, 5, 2, 4}, new int[]{5, 1, 4, 2}));
    }
}

