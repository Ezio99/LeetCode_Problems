package org.hireme.datastructure.tree;

public class FenwickTree {

    private long[] tree;

    public FenwickTree(int size) {
        tree = new long[size + 1];//1 indexed
    }

    //Assuming values is 1 indexed
    public FenwickTree(long[] values) {
        if (values == null) {
            throw new IllegalArgumentException("Values cant be null");
        }

        int j;
        tree = values.clone();
        for (int i = 1; i < tree.length; i++) {
            j = i + findLsb(i);
            if (j < tree.length) {
                tree[j] += tree[i];
            }

        }
    }

    //Other way to construct the tree
//    public FenwickTree(long[] values) {
//        if (values == null) {
//            throw new IllegalArgumentException("Values cant be null");
//        }
//
//        tree = new long[values.length];
//        for (int i = 1; i < values.length; i++) {
//            update(values[i], i); // Use the update method to populate the tree
//        }
//    }

    private static int findLsb(int n) {
        //Equivalent to Integer.lowestOneBit(n) or n & -n or n & ((~n)+1)
        return n & -n;
    }

    public long prefixSum(int i) {
        int index = i;
        long sum = 0;
        while (index > 0) {
            sum += tree[index];
            index -= findLsb(index);
        }
        return sum;
    }

    public long rangeQuery(int i, int j) {
        if (i > j) {
            throw new IllegalArgumentException("i must be <= j");
        }
        return prefixSum(j) - prefixSum(i - 1);
    }

    //Add k value to the value at index  in the tree
    public void update(long k, int index) {

        while (index < tree.length) {
            tree[index] += k;
            index += findLsb(index);
        }
    }

    public static void main(String[] args) {
        // Test input: 1-indexed array
        long[] values = {0, 1, 2, 3, 4, 5}; // 0 is placeholder for 1-based indexing

        // Construct the Fenwick Tree
        FenwickTree fenwickTree = new FenwickTree(values);

        // Test prefix sums
        System.out.println("Prefix sum up to index 3: " + fenwickTree.prefixSum(3)); // Expected: 6 (1 + 2 + 3)
        System.out.println("Prefix sum up to index 5: " + fenwickTree.prefixSum(5)); // Expected: 15 (1 + 2 + 3 + 4 + 5)

        // Test range queries
        System.out.println("Range sum from index 2 to 4: " + fenwickTree.rangeQuery(2, 4)); // Expected: 9 (2 + 3 + 4)
        System.out.println("Range sum from index 1 to 3: " + fenwickTree.rangeQuery(1, 3)); // Expected: 6 (1 + 2 + 3)

        // Test updates
        fenwickTree.update(3, 2); // Add 3 to index 2 (values[2] = 2 -> 5)
        System.out.println("After updating index 2 by +3:");
        System.out.println("Prefix sum up to index 3: " + fenwickTree.prefixSum(3)); // Expected: 9 (1 + (2 + 3) + 3)
        System.out.println("Range sum from index 2 to 4: " + fenwickTree.rangeQuery(2, 4)); // Expected: 12 ((2+3) + 3 + 4)

        fenwickTree.update(-2, 5); // Subtract 2 from index 5 (values[5] = 5 -> 3)
        System.out.println("After updating index 5 by -2:");
        System.out.println("Prefix sum up to index 5: " + fenwickTree.prefixSum(5)); // Expected: 16
        System.out.println("Range sum from index 4 to 5: " + fenwickTree.rangeQuery(4, 5)); // Expected: 7 (4 + (5-2))

        // Edge case: Range sum for the entire array
        System.out.println("Range sum from index 1 to 5: " + fenwickTree.rangeQuery(1, 5)); // Expected: 16
    }


}
