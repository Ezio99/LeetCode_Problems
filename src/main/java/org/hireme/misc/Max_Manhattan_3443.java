package org.hireme.misc;

import java.util.HashMap;

public class Max_Manhattan_3443 {


    public int optimal(String s, int k) {
        int n = s.length();
        int north = 0, south = 0, east = 0, west = 0;
        int maxDist = 0;

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == 'N') north++;
            else if (ch == 'S') south++;
            else if (ch == 'E') east++;
            else west++;

            maxDist = Math.max(maxDist, Math.abs(north - south) + Math.abs(east - west) + (k * 2));
            maxDist = Math.min(maxDist, i + 1);
        }

        return maxDist;
    }

    /**
     * dir NE,NW,SE,SW
     * N,E +
     * S,W -
     *
     * @param s
     * @param k
     * @return
     */
    public int maxDistance(String s, int k) {
        int maxDist = 0, tmp;
        char ch;
        for (int dir = 0; dir < 4; dir++) {
            int[] pos = new int[2];
            tmp = k;
            for (int j = 0; j < s.length(); j++) {
                ch = s.charAt(j);
                switch (ch) {
                    case 'N':
                        if (tmp > 0 && (dir == 2 || dir == 3)) {
                            pos[1]--;
                            tmp--;
                        } else {
                            pos[1]++;
                        }
                        break;
                    case 'S':
                        if (tmp > 0 && (dir == 1 || dir == 0)) {
                            pos[1]++;
                            tmp--;
                        } else {
                            pos[1]--;
                        }
                        break;
                    case 'E':
                        if (tmp > 0 && (dir == 1 || dir == 3)) {
                            pos[0]--;
                            tmp--;
                        } else {
                            pos[0]++;
                        }
                        break;
                    case 'W':
                        if (tmp > 0 && (dir == 0 || dir == 2)) {
                            pos[0]++;
                            tmp--;
                        } else {
                            pos[0]--;
                        }
                        break;
                }
                maxDist = Math.max(maxDist, Math.abs(pos[0]) + Math.abs(pos[1]));
            }
        }

        return maxDist;
    }

    public static void main(String[] args) {
        Max_Manhattan_3443 obj = new Max_Manhattan_3443();
        System.out.println(obj.maxDistance("NWSE", 1));
    }


//             switch (ch) {
//        case 'N':
//            pos[1]++;
//            break;
//        case 'S':
//            pos[1]--;
//            break;
//        case 'E':
//            pos[0]++;
//            break;
//        case 'W':
//            pos[0]--;
//            break;
//
//    }


    /**
     *     int tmp;
     *         if (frequency[0] >= frequency[3]) {
     *             tmp = frequency[3];
     *             frequency[0] += Math.min(k, frequency[3]);
     *             frequency[3] -= Math.min(k, frequency[3]);
     *         } else {
     *             tmp = frequency[0];
     *             frequency[3] += Math.min(k, frequency[0]);
     *             frequency[0] -= Math.min(k, frequency[0]);
     *         }
     *         k = Math.max(k - tmp, 0);
     *
     *         if (frequency[1] >= frequency[2]) {
     *             tmp = frequency[2];
     *             frequency[1] += Math.min(k, frequency[2]);
     *             frequency[2] -= Math.min(k, frequency[2]);
     *         } else {
     *             tmp = frequency[1];
     *             frequency[2] += Math.min(k, frequency[1]);
     *             frequency[1] -= Math.min(k, frequency[1]);
     *         }
     *
     *         return Math.abs(frequency[0] - frequency[3]) + Math.abs(frequency[1] - frequency[2]);
     */


}
