package org.hireme.playground.Recursion;

public class Multiplication_with_recursion {

    public static double multiply(double a, double b) {
        if (b == 0) {
            return 0;
        }

        if (b < 0) {
            return multiply(a, b + 1) - a;
        }
        return multiply(a, b - 1) + a;
    }

    public static void main(String[] args) {
        System.out.println(multiply(-6, 0.5));
    }
}
