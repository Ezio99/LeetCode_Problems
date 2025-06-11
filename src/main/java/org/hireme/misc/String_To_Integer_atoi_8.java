package org.hireme.misc;

public class String_To_Integer_atoi_8 {
    public int myAtoi(String s) {
        if (s.isEmpty()) return 0;
        long res = 0;
        s = s.trim();
        if (s.isEmpty()) return 0;
        int sign = 1;
        int r = 0;
        if (s.charAt(0) == '-') {
            sign = -1;
            r = 1;
        } else if (s.charAt(0) == '+') {
            r = 1;
        }

        while (r < s.length() && Character.isDigit(s.charAt(r))) {
            int num = s.charAt(r) - '0';

            res = res * 10 + num;
            if (sign == -1 && res <= Integer.MIN_VALUE) return Integer.MIN_VALUE;
            if (sign == 1 && res >= Integer.MAX_VALUE) return Integer.MAX_VALUE;
            r++;
        }


        return (int) res;

    }

    public static void main(String[] args) {
        String_To_Integer_atoi_8 obj = new String_To_Integer_atoi_8();
        System.out.println(obj.myAtoi("42"));
        System.out.println(Integer.MAX_VALUE);
    }
}
