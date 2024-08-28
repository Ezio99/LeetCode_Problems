package org.hireme.hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    DFS: Go through the array and everytime we find 1, start colouring and counting the region, store it in
    colour - 2 index. Don't DFS already coloured regions.
 */

public class DFS_Connected_Cell_in_a_Grid {

    static List<Integer> regionSize;
    static int color = 2;
    //    static int[] visited;
    static int numOfarrays, arrayLength;

    public static int maxRegion(List<List<Integer>> grid) {
        // Write your code here
        numOfarrays = grid.size();
        arrayLength = grid.get(0).size();

        regionSize = new ArrayList<Integer>();

        int max = 0;


        for (int i = 0; i < numOfarrays; i++) {
            for (int j = 0; j < arrayLength; j++) {
                if (grid.get(i).get(j) == 1) {
                    regionSize.add(0);
                    dfs(i, j, grid);
                    if (regionSize.get(color - 2) > max) {
                        max = regionSize.get(color - 2);
                    }
                    color++;
                }
            }
        }

        return max;
    }

    private static void dfs(int x, int y, List<List<Integer>> grid) {
        grid.get(x).set(y, color);
        regionSize.set(color - 2, regionSize.get(color - 2) + 1);

        for (int i = -1; i < 2; i++) {
            if (x + i < 0 || x + i >= numOfarrays) {
                continue;
            }
            for (int j = -1; j < 2; j++) {
                if (i == 0 && j == 0)
                    continue;

                if (j + y < 0 || j + y >= arrayLength)
                    continue;

                if (grid.get(x + i).get(y + j) == 1)
                    dfs(x + i, y + j, grid);


            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> grid = new ArrayList<>();
        grid.add(Arrays.asList(0, 0, 1, 1));
        grid.add(Arrays.asList(0, 0, 1, 0));
        grid.add(Arrays.asList(0, 1, 1, 0));
        grid.add(Arrays.asList(0, 1, 0, 0));
        grid.add(Arrays.asList(1, 1, 0, 0));

        // Call the function
        int result = maxRegion(grid);
    }


}
