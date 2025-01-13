package org.hireme.leetcode.bitmanipulation;

public class Find_K_Bit_In_N_1545 {
    public static char findKthBit(int n, int k) {
        if (n == 0) {
            return '0';
        }

        StringBuilder sp = new StringBuilder("011");

        if (n == 1) {
            return sp.charAt(k-1);
        }

        n -= 2;
        StringBuilder tmp, tmp2;

        while (n-- > 0) {
            tmp = sp;


            sp = invertThenReverseBinary(sp);
            tmp.append('1');
            tmp.append(sp);
            sp = tmp;

        }

        return sp.charAt(k - 1);
    }

    public static StringBuilder invertThenReverseBinary(StringBuilder s) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0')
                res.append('1');
            else
                res.append('0');
        }

        res.reverse();
        return res;
    }

    public static void main(String[] args) {
        System.out.println(findKthBit(4, 11));
    }
}
