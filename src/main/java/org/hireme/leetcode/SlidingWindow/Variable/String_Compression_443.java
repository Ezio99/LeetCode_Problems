package org.hireme.leetcode.SlidingWindow.Variable;

public class String_Compression_443 {
    public int compress(char[] chars) {
        if (chars.length == 1) {
            return 1;
        }
        int l = 0, ctr = 1, r = 1, replacementptr = 0;

        while (r < chars.length) {
            if (chars[l] != chars[r]) {
                chars[replacementptr++] = chars[l];
                if (ctr > 1) {
                    for (char ch : Integer.toString(ctr).toCharArray()) {
                        chars[replacementptr++] = ch;
                    }
                }
                ctr = 0;
                l = r;
            }

            ctr++;
            r++;
        }
        chars[replacementptr++] = chars[l];
        if (ctr > 1) {
            for (char ch : Integer.toString(ctr).toCharArray()) {
                chars[replacementptr++] = ch;
            }
        }

        return replacementptr;
    }
}
