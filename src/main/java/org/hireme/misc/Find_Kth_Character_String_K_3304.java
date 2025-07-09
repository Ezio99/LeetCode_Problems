package org.hireme.misc;

public class Find_Kth_Character_String_K_3304 {
    public char kthCharacter(int k) {
        //Log 2 of k
        double x = Math.log10(k) / Math.log10(2);
        long tmp=k;
        int q = (int) x;
        int val = 0;
        long closest;
        while (q >= 0) {
            closest =  (long) Math.pow(2, q);
            if (tmp > closest) {
                val = (val + 1) % 26;
                tmp = tmp - closest;
            }
            q--;
        }


        return (char) (val + 'a');
    }
}
