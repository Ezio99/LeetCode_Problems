package org.hireme.leetcode.prefix_sum;

public class Shifting_Letters_2_2381 {

    public static String shiftingLetters(String s, int[][] shifts) {

        int[] fenwickTree = new int[s.length() + 1];
        int ctr = 1, sum = 0;
        int j;

        for (int i = 0; i < s.length(); i++) {
            update(fenwickTree,s.charAt(i),ctr);
            ctr++;
        }


        for (int[] shift : shifts) {
            int start = shift[0];
            int end = shift[1];
            int direction = shift[2];

            update(fenwickTree,direction==0?-1:1,start);
        }

        StringBuilder sb = new StringBuilder();
        ctr = 0;
        while (ctr < fenwickTree.length) {
            int newVal = ctr == 0 ? fenwickTree[ctr] : fenwickTree[ctr] - fenwickTree[ctr - 1];
            if (newVal < 97) {
                newVal = 123 - (97 - newVal);
            } else if (newVal > 122) {
                newVal = 96 + (newVal - 122);
            }
            sb.append((char) newVal);

            ctr++;
        }


        return sb.toString();
    }

    private static int lsb(int n) {
        return n & -n;
    }

    private static void update(int[] tree, int value, int index) {
        while (index < tree.length) {
            tree[index] += value;
            index += lsb(index);
        }
    }

    public long prefixSum(int[] tree ,int i) {
        int index = i;
        long sum = 0;
        while (index > 0) {
            sum += tree[index];
            index -= lsb(index);
        }
        return sum;
    }

    public long rangeQuery(int[] tree,int i, int j) {
        if (i > j) {
            throw new IllegalArgumentException("i must be <= j");
        }
        return prefixSum(tree,j) - prefixSum(tree,i - 1);
    }

    public static void main(String[] args) {

        String s = "abc";
        int[][] shifts = {
                {0, 1, 0}, // shift from index 0 to 1 left
                {1, 2, 1},  // shift from index 1 to 2 right
                {0, 2, 1}  // shift from index 1 to 2 right
        };


        System.out.println(shiftingLetters(s, shifts));
    }












    /*
        public static String shiftingLetters(String s, int[][] shifts) {

        int[] sumArray = new int[s.length()];
        int ctr = 0, sum = 0;

        for (int i = 0; i < s.length(); i++) {
            sum += s.charAt(i);
            sumArray[ctr++] = sum;
        }


        for (int[] shift : shifts) {
            int start = shift[0];
            int end = shift[1];
            int direction = shift[2];

            sumArray[start] = direction == 1 ? sumArray[start]+1 : sumArray[start]-1;
            sumArray[end] = direction == 1 ? sumArray[end]+1 : sumArray[end]-1;
        }

        StringBuilder sb = new StringBuilder();
        ctr = 0;
        while (ctr < sumArray.length) {
            int newVal = ctr == 0 ? sumArray[ctr] : sumArray[ctr] - sumArray[ctr - 1];
            if (newVal < 97) {
                newVal = 123 - (97 - newVal);
            } else if (newVal > 122) {
                newVal = 96 + (newVal - 122);
            }
            sb.append((char) newVal);

            ctr++;
        }


        return sb.toString();
    }
     */

}
