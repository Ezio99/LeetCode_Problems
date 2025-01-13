package org.hireme.neetcode.bitmanipulation;

public class Reverse_bits {
    public static int reverseBits(int n) {
        System.out.println("Number to convert " + n);
        System.out.println("Number to convert in binary " + Integer.toBinaryString(n));

        int result = 0;

        for (int i = 0; i < 32; i++) {
            int lsb = n & 1;

            result = (result << 1) | lsb;

            n >>=1;
        }

        System.out.println("Result " + Integer.toBinaryString(result));
        return result;
    }

    public static void main(String[] args) {
        System.out.println(reverseBits(Integer.parseInt("00000000000000000000000000010101", 2)));
    }
}
