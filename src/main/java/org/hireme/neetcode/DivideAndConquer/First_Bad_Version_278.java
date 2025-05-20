package org.hireme.neetcode.DivideAndConquer;

public class First_Bad_Version_278 {
    public int firstBadVersion(int n) {
        int l = 1, r = n;
        int mid;
        while (l <= r) {
            mid = l + (r - l) / 2;
            if (isBadVersion(mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        return r;
    }

    //Dummy
    public boolean isBadVersion(int n) {
        return n % 2 == 0;
    }
}
