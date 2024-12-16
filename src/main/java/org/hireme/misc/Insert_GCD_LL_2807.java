package org.hireme.misc;

public class Insert_GCD_LL_2807 {

    //Euclids formula
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(gcd(12, 16));
    }

}
