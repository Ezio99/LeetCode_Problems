package org.hireme.neetcode.bitmanipulation;

import java.util.Arrays;

public class Counting_Bits {
    public int[] countBits(int n) {
        int[] result = new int[n + 1];
        int curr;
        for (int i = 1; i <= n; i++) {
            result[i] = result[i>>1]+(i&1);
        }

        return result;

    }

    private int numberOfOnes(int x) {
        int ans = 0;
        while (x > 0) {
            ans += x & 1;
            x = x >> 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        Counting_Bits obj = new Counting_Bits();
//        System.out.println(Arrays.toString(obj.countBits(4)));
        System.out.println(9>>1);
    }
}
