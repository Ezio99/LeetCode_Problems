package org.hireme.neetcode.DivideAndConquer;

public class First_Bad_Version_278 {
    public int firstBadVersion(int n) {
        int l = 1, r = n;
        int mid;
        while (l <= r) {
            mid = l + (r - l) / 2;
            if (isBadVersion(mid)) {
                r = mid-1;
            } else {
                l = mid + 1;
            }
        }

        return r+1;
    }

    //Dummy
    public boolean isBadVersion(int n) {
        return n % 2 == 0;
    }
}
