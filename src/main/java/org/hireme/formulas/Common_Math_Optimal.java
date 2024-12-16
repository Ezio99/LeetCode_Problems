package org.hireme.formulas;

public class Common_Math_Optimal {

    //Optimal way to find GCD/HCF (Euclid's algorithm)
    /*
    E.g. GCD(12,18) = GCD(18,6) = GCD(6,0) = 6

    GCD(56,15)⇒GCD(15,56%15)=GCD(15,11)⇒GCD(11,15%11)=GCD(11,4)⇒GCD(4,11%4)=GCD(4,3)⇒GCD(3,4%3)=GCD(3,1)⇒GCD(1,3%1)=1
    GCD(15,56)⇒GCD(56,15%56)=GCD(56,15)
     */
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // Function to compute LCM
    public static int lcm(int a, int b) {
        return Math.abs(a * b) / gcd(a, b); // Avoid overflow by taking absolute value
    }

    public static boolean isPrime(int n) {
        // Step 1: Handle edge cases
        if (n <= 1) return false; // Numbers <= 1 are not prime
        if (n <= 3) return true; // 2 and 3 are prime
        if (n % 2 == 0 || n % 3 == 0) return false; // Eliminate multiples of 2 and 3

        // Step 2: Check divisors of the form 6k ± 1
        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) return false;
        }

        return true; // No divisors found, n is prime
    }
}
