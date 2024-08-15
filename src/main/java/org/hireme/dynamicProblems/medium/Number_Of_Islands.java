package org.hireme.dynamicProblems.medium;

import java.util.Arrays;

public class Number_Of_Islands {

    static int numOfComponents = 0;

    static int[][][] id;
    static int[][] size;

    //Make an array of unions

    public static int numIslands(char[][] grid) {


        if (grid.length < 1) {
            return 0;
        }

        int numOfArrs = grid.length, numOfElementsInArr = grid[0].length;

        id = new int[numOfArrs][numOfElementsInArr][];
        size = new int[numOfArrs][numOfElementsInArr];

        for (int i = 0; i < numOfArrs; i++) {
            for (int j = 0; j < numOfElementsInArr; j++) {
                if(grid[i][j]=='1'){
                    numOfComponents+=1;
                    id[i][j] = new int[]{i, j};
                    size[i][j] = 1;
                }
                else{
                    id[i][j] = new int[]{-1,-1};
                    size[i][j] = 0;
                }

            }
        }


        for (int i = 0; i < numOfArrs; i++) {
            for (int j = 0; j < numOfElementsInArr; j++) {
                if (grid[i][j] == '1') {
                    //Check only down and right elements for islands
                    if (j + 1 < numOfElementsInArr && grid[i][j + 1] == '1') {
                        union(new int[]{i, j}, new int[]{i, j + 1});
                    }

                    if (i + 1 < numOfArrs && grid[i + 1][j] == '1') {
                        union(new int[]{i, j}, new int[]{i + 1, j});
                    }
                }
            }
        }

        return numOfComponents;


    }

    public static int[] findRoot(int x, int y) {

        int[] root = new int[]{x, y};
        while (id[root[0]][root[1]][0] != root[0] || id[root[0]][root[1]][1] != root[1]) {
            int rootxpos = root[0],rootypos = root[1];
            root[0] = id[rootxpos][rootypos][0];
            root[1] = id[rootxpos][rootypos][1];
        }

        int[] current = new int[]{x, y};
        int[] next = new int[2];
        while (id[current[0]][current[1]][0] != root[0] && id[current[0]][current[1]][1] != root[1]) {
            next[0] = id[current[0]][current[1]][0];
            next[1] = id[current[0]][current[1]][1];

            id[current[0]][current[1]][0] = root[0];
            id[current[0]][current[1]][1] = root[1];

            current[0] = next[0];
            current[1] = next[1];
        }

        return root;
    }

    private static boolean isConnected(int[] x, int[] y) {
        int[] root1 = findRoot(x[0], x[1]);
        int[] root2 = findRoot(y[0], y[1]);

        return Arrays.equals(root1, root2);
    }


    private static void union(int[] coord1, int[] coord2) {
        int[] root1 = findRoot(coord1[0], coord1[1]);
        int[] root2 = findRoot(coord2[0], coord2[1]);


        if (Arrays.equals(root1, root2))
            return;

        if (size[root1[0]][root1[1]] >= size[root2[0]][root2[1]]) {
            id[root2[0]][root2[1]][0] = root1[0];
            id[root2[0]][root2[1]][1] = root1[1];
            size[root1[0]][root1[1]] = size[root1[0]][root1[1]] + size[root2[0]][root2[1]];
        } else {
            id[root1[0]][root1[1]][0] = root2[0];
            id[root1[0]][root1[1]][1] = root2[1];
            size[root2[0]][root2[1]] = size[root2[0]][root2[1]] + size[root1[0]][root1[1]];
        }

        numOfComponents-=1;
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

        System.out.println(numIslands(grid));


    }


}
