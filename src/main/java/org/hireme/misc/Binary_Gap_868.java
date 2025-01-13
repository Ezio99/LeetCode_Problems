package org.hireme.misc;

public class Binary_Gap_868 {
    public static int binaryGap(int n) {
        String s = Integer.toBinaryString(n);
        int ctr = 1, ans = 0;
        int startIndex = s.indexOf('1');

        for (int i = startIndex + 1; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                if (ctr > ans) {
                    ans = ctr;
                }
                ctr = 1;
            } else {
                ctr++;
            }
        }
        return ans;
    }

    public static int binaryGapBitMap(int n) {
        int ctr = 1, ans = 0;

        while (n > 0) {
            if ((n & 1) == 1)
                break;
            n = n >> 1;
        }

        n = n >> 1;
        while (n > 0) {
            if ((n & 1) == 1) {
                if (ctr > ans) {
                    ans = ctr;
                }
                ctr = 1;
            }
            else {
                ctr++;
            }
            n = n>>1;
        }
        return ans;

    }

    public static void main(String[] args) {
        System.out.println(binaryGapBitMap(22));
    }
}
