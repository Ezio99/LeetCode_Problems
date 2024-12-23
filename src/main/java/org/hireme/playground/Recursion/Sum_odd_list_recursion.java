package org.hireme.playground.Recursion;

public class Sum_odd_list_recursion {

    public static int sum_odd(int[] list, int ctr) {
        if (ctr == list.length) {
            return 0;
        }

        int val = 0;

        if (list[ctr] % 2 != 0) {
            val = list[ctr];
        }
        return sum_odd(list, ctr + 1) + val;
    }

    public static int prod_even(int[] list, int ctr) {
        if (ctr == list.length) {
            return 1;
        }

        if (list[ctr] == 0) {
            //If you come across a 0 the product is 0 anyway
            return 0;
        }

        int val = 1;

        if (list[ctr] % 2 == 0) {
            val = list[ctr];
        }
        return prod_even(list, ctr + 1) * val;
    }


    public static void main(String[] args) {
        System.out.println(sum_odd(new int[]{5, 5, 8, 2, 4}, 0));
        System.out.println(prod_even(new int[]{5, 5, -8, 2, 4}, 0));
        System.out.println(prod_even(new int[]{1, 2, 3, 4, 5, 6, 7, 8}, 0));
    }
}
