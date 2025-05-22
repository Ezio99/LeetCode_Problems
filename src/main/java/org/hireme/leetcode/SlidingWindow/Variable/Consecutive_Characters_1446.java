package org.hireme.leetcode.SlidingWindow.Variable;

public class Consecutive_Characters_1446 {
    public int maxPower(String s) {
        int l = 0, maxL = 1, r = 1;

        while (r < s.length()) {
            if (s.charAt(r) != s.charAt(l)) {
                l = r;
            }

            maxL = Math.max(r - l + 1, maxL);

            r++;
        }

        return maxL;
    }
}
