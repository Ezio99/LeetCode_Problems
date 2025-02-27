package org.hireme.leetcode.dynamicProblems.easy;

public class Tribonacci_1137 {
    public int tribonacci(int n) {
//        int[] cache = new int[n + 1];
//        return topDownHelper(n, cache);

        return bottomUpHelper(n);
    }

    private int bottomUpHelper(int n) {
        if (n < 3) {
            return n == 2 ? 1 : n;
        }
        int t0 = 0, t1 = 1, t2 = 1, ans;
        for (int i = 0; i < n - 2; i++) {
            ans = t1 + t2 + t0;
            t0 = t1;
            t1 = t2;
            t2 = ans;
        }

        return t2;

    }

    private int topDownHelper(int n, int[] cache) {
        if (n < 3) {
            return n == 2 ? 1 : n;
        }
        if (cache[n] != 0) {
            return cache[n];
        }

        cache[n] = topDownHelper(n - 1, cache) + topDownHelper(n - 2, cache) + topDownHelper(n - 3, cache);

        return cache[n];
    }

    private int dfsHelper(int n) {
        if (n < 3) {
            return n == 2 ? 1 : n;
        }

        return dfsHelper(n - 1) + dfsHelper(n - 2) + dfsHelper(n - 3);
    }

    public static void main(String[] args) {
        Tribonacci_1137 obj = new Tribonacci_1137();
        System.out.println(obj.tribonacci(25));
    }
}
