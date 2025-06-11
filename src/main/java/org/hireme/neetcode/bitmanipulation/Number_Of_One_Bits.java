package org.hireme.neetcode.bitmanipulation;

public class Number_Of_One_Bits {
    public int hammingWeight(int n) {
        int ctr = 0;
        while (n > 0) {
            ctr += (n&1);
            n >>= 1;
        }
        return ctr;
    }

    public static void main(String[] args) {
        Number_Of_One_Bits obj = new Number_Of_One_Bits();
        System.out.println(obj.hammingWeight(11));
    }
}
