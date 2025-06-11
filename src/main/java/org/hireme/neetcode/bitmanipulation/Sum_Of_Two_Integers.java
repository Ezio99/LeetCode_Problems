package org.hireme.neetcode.bitmanipulation;


//Given two integers a and b, return the sum of the two integers without using the + and - operators.

public class Sum_Of_Two_Integers {
    public int getSum(int a, int b) {
        int and = (a & b) << 1, xor = a ^ b, sum;
//        System.out.println("xor "+Integer.toBinaryString(xor));
//        System.out.println("and "+Integer.toBinaryString(and));
        int tmp;
        while (and != 0) {
            //Left Shifted 1 as this is basically carry which needs to be added to next
            tmp = (xor & and) << 1;
            xor = xor ^ and;
            and=tmp;


//            System.out.println("xor "+Integer.toBinaryString(xor));
//            System.out.println("and "+Integer.toBinaryString(and));
        }

        return xor;
    }

    public static void main(String[] args) {
        Sum_Of_Two_Integers obj = new Sum_Of_Two_Integers();
        System.out.println(obj.getSum(9, 11));
    }


//    aLsd = (a & 1);
//    bLsd = (b & 1);
//    sum += (int) Math.pow(2 * (aLsd | bLsd | carry), ctr);
//            if (aLsd == 1 && bLsd == 1 || aLsd == 1 && carry == 1 || bLsd == 1 && carry == 1) {
//        carry = 1;
//    } else {
//        carry = 0;
//    }
//    a >>= 1;
//    b >>= 1;
//    ctr++;
}
