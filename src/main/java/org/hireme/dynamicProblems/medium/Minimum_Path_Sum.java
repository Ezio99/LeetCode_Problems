package org.hireme.dynamicProblems.medium;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Minimum_Path_Sum {

    public int minPathSum(int[][] grid) {

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });

        int numberOfArrs = grid.length, arrayLength = grid[0].length;

        int[] destination = new int[]{numberOfArrs - 1, arrayLength - 1};

        //Starting from top left
        pq.offer(new int[]{0, 0, grid[0][0]});

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int currentRow = current[0], currentCol = current[1], distToReachHere = current[2];

            if (currentRow == destination[0] && currentCol == destination[1]) {
                return distToReachHere;
            }

            if (currentCol + 1 < arrayLength) {
                if (currentRow == destination[0] && currentCol + 1 == destination[1]) {
                    return grid[currentRow][currentCol + 1] + distToReachHere;
                }
                pq.offer(new int[]{currentRow, currentCol + 1, grid[currentRow][currentCol + 1] + distToReachHere});
            }

            if (currentRow + 1 < numberOfArrs) {
                if (currentRow + 1 == destination[0] && currentCol == destination[1]) {
                    return grid[currentRow + 1][currentCol] + distToReachHere;
                }
                pq.offer(new int[]{currentRow + 1, currentCol, grid[currentRow + 1][currentCol] + distToReachHere});
            }


        }

        return -1;


    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {1, 3, 1}, {1, 5, 1}, {4, 2, 1}
        };
        System.out.println(new Minimum_Path_Sum().minPathSum(grid));
    }

}
