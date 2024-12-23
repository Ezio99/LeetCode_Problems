package org.hireme.leetcode.graph.medium;

public class Number_Of_Islands {

    static int numOfComponents = 0;

    static int[] id;
    static int[] size;



    //Make an array of unions

    public static int numIslands(char[][] grid) {


        if (grid.length < 1) {
            return 0;
        }

        int numOfArrs = grid.length, numOfElementsInArr = grid[0].length;

        //Think like indexing each array's index by mod
        id = new int[numOfArrs * numOfElementsInArr];
        size = new int[numOfArrs * numOfElementsInArr];

        for (int i = 0; i < numOfArrs; i++) {
            for (int j = 0; j < numOfElementsInArr; j++) {
                if (grid[i][j] == '1') {
                    numOfComponents += 1;
                    id[i*numOfElementsInArr + j%numOfElementsInArr] = i*numOfElementsInArr + j%numOfElementsInArr;
                    size[i*numOfElementsInArr + j%numOfElementsInArr] = 1;
                } else {
                    id[i*numOfElementsInArr + j%numOfElementsInArr] = -1;
                    size[i*numOfElementsInArr + j%numOfElementsInArr] = 0;
                }

            }
        }


        for (int i = 0; i < numOfArrs; i++) {
            for (int j = 0; j < numOfElementsInArr; j++) {
                if (grid[i][j] == '1') {
                    //Check only down and right elements for islands
                    if (j + 1 < numOfElementsInArr && grid[i][j + 1] == '1') {
                        union(i*numOfElementsInArr + j%numOfElementsInArr,i*numOfElementsInArr + (j+1)%numOfElementsInArr);
                    }

                    if (i + 1 < numOfArrs && grid[i + 1][j] == '1') {
                        union(i*numOfElementsInArr + j%numOfElementsInArr,(i+1)*numOfElementsInArr + j%numOfElementsInArr);
                    }
                }
            }
        }

        return numOfComponents;


    }

    public static int findRoot(int x) {

        int root = x;
        while (id[root]!=root) {
            root = id[root];
        }

        int current = x;
        int next;
        while (id[current]!=root) {
            next = id[current];
            id[current] = root;
            current=next;
        }

        return root;
    }

    private static boolean isConnected(int x, int y) {
        return findRoot(x) == findRoot(y);
    }


    private static void union(int coord1, int coord2) {
        int root1 = findRoot(coord1);
        int root2 = findRoot(coord2);


        if (root1 == root2)
            return;

        if (size[root1] >= size[root2]) {
            id[root2] = root1;
            size[root1] += size[root2];
        } else {
            id[root1] = root2;
            size[root2] += size[root1];
        }

        numOfComponents -= 1;
    }

    public static void main(String[] args) {
//        char[][] grid = {
//                {'1', '1', '1', '0', '0'},
//                {'1', '1', '0', '0', '1'},
//                {'0', '0', '0', '1', '1'},
//                {'0', '1', '0', '0', '0'},
//                {'1', '0', '1', '1', '1'}
//        };

//        char[][] grid = {
//                {'1', '1', '0', '0', '0'},
//                {'1', '1', '0', '0', '0'},
//                {'0', '0', '1', '0', '0'},
//                {'0', '0', '0', '1', '1'}
//        };

        char[][] grid = {
                {'1', '1', '1', '1', '1', '0', '1', '1', '1', '1'},
                {'1', '0', '1', '0', '1', '1', '1', '1', '1', '1'},
                {'0', '1', '1', '1', '0', '1', '1', '1', '1', '1'},
                {'1', '1', '0', '1', '1', '0', '0', '0', '0', '1'},
                {'1', '0', '1', '0', '1', '0', '0', '1', '0', '1'},
                {'1', '0', '0', '1', '1', '1', '0', '1', '0', '0'},
                {'0', '0', '1', '0', '0', '1', '1', '1', '1', '0'},
                {'1', '0', '1', '1', '1', '0', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1', '1', '1', '1', '0', '1'},
                {'1', '0', '1', '1', '1', '1', '1', '1', '1', '0'}
        };

//        char[][] grid = {
//                {'1'},{'1'}
//        };

        System.out.println(numIslands(grid));


    }


}
