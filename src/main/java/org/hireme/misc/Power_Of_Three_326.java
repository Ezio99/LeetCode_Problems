package org.hireme.misc;

public class Power_Of_Three_326 {
    public boolean isPowerOfThree(int n) {
        if (n <= 0) return false;

        double logVal = Math.log10(n) / Math.log10(3);
        return Math.abs(logVal - Math.round(logVal)) < 1e-10; //Tolerance to floating precision errors
    }


    public boolean isPowerOfThreeAlt(int n) {
        return n > 0 && 1162261467 % n == 0;  // 3^19 is the largest power of 3 < 2^31
    }

    public boolean isPowerOfThreeIter(int n) {
        if(n<1)return false;

        while(n>1){
            if(n%3!=0){
                return false;
            }
            n/=3;
        }

        return n==1;
    }

    public boolean isPowerOfThreerecurs(int n) {
        if(n<1)return false;
        if(n==1) return true;


        return n%3==0 && isPowerOfThree(n/3);
    }
}
