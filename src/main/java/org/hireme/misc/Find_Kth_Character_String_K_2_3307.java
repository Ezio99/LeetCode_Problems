package org.hireme.misc;

public class Find_Kth_Character_String_K_2_3307 {
    public char kthCharacter(long k, int[] operations) {
        //Log 2 of k
        double x = Math.log10(k) / Math.log10(2);
        int q = (int) x;
        int val = 0;
        long closest;
        while (q >= 0) {
            closest = (long) Math.pow(2, q);
            //If the character is in the part which is not in string before it, it will undergo the operation
            if (k > closest) {
                val = (val + operations[q]) % 26;
                k = k - closest;
            }
            q--;
        }


        return (char) (val + 'a');
    }

    public static void main(String[] args) {
        Find_Kth_Character_String_K_2_3307 obj = new Find_Kth_Character_String_K_2_3307();
        System.out.println(obj.kthCharacter(12145134613L, new int[]{0,0,0,0,1,0,0,0,1,1,1,1,1,0,1,0,0,0,1,0,0,0,0,0,1,1,0,1,0,0,1,1,1,1,1}));
//        System.out.println(obj.kthCharacter(5, new int[]{0, 0, 0, 0}));
    }
}
