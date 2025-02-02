package org.hireme.misc;

import java.util.Arrays;

public class One_Segment_of_Ones_1784 {

    public boolean checkOnesSegment(String s) {
        boolean isSeenOne = false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                if (isSeenOne) {
                    if (s.charAt(i - 1) != '1') {
                        return false;
                    }
                } else {
                    isSeenOne = true;
                }
            }
        }

        return isSeenOne;
    }

    public boolean canBeEqual(String s1, String s2) {
        return ((s1.charAt(0) == s2.charAt(0) && s1.charAt(2) == s2.charAt(2)) ||
                (s1.charAt(0) == s2.charAt(2) && s1.charAt(2) == s2.charAt(0)))
                &&
                ((s1.charAt(1) == s2.charAt(1) && s1.charAt(3) == s2.charAt(3)) ||
                        (s1.charAt(1) == s2.charAt(3) && s1.charAt(3) == s2.charAt(1)));
    }

    public int[] sumZero(int n) {
        int[] result = new int[n];
        int index = 0;
        if (n % 2 != 0) {
            result[index++] = 0;
        }
        else {
            n-=1;
        }
        int ctr = 1;
        for (int i = index; i <= n / 2; i++) {
            result[index++] = ctr;
            result[index++] = ctr * -1;
            ctr++;
        }

        return result;

    }

    public static void main(String[] args) {
        One_Segment_of_Ones_1784 obj = new One_Segment_of_Ones_1784();
        System.out.println(Arrays.toString(obj.sumZero(4)));
        System.out.println(Arrays.toString(obj.sumZero(5)));
    }


}
