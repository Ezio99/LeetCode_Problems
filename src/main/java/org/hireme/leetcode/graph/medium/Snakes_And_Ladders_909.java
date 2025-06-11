package org.hireme.leetcode.graph.medium;


import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

//BFS
public class Snakes_And_Ladders_909 {

    /**
     * DP works well when:
     * <p>
     * There’s overlapping subproblems.
     * <p>
     * You can define the problem in terms of optimal substructure — e.g., dp[i] = min(dp[i - 1], ..., dp[i - 6]) + 1.
     * <p>
     * Here’s the catch: Due to the non-linear jumps caused by snakes and ladders, you can’t guarantee that dp[i] only depends on the previous 6 steps — because:
     * <p>
     * A snake could send you far back.
     * <p>
     * A ladder could send you far ahead.
     * <p>
     * Multiple paths could lead to the same square with a different number of moves.
     * <p>
     * This introduces cycles and non-linearity, breaking standard DP assumptions.
     */

    public int snakesAndLadders(int[][] board) {
        int currRolls = 0;
        int r = board.length, c = board[0].length;
        Queue<int[]> queue = new LinkedList<>();
        //Could also be done using set
        boolean[] visited = new boolean[r * r + 1];
        // row,col,curRolls,pos
        queue.offer(new int[]{currRolls, 1});
        visited[1] = true;

        int pos;
        int newPos;
        int[] newIndex;
        while (!queue.isEmpty()) {
            int[] index = queue.poll();
            pos = index[1];

            //BFS guaranteed first time we reach its the shortest path
            if (pos == r * r) {
                return index[0];
            }


            for (int i = 1; i <= 6; i++) {
                newPos = pos + i;
                if ((pos + i <= r * r)) {
                    newIndex = convertToIndex(newPos, r);
                    if (board[newIndex[0]][newIndex[1]] != -1) {
                        newPos = board[newIndex[0]][newIndex[1]];
                    }
                    if (!visited[newPos]) {
                        queue.add(new int[]{index[0] + 1, newPos});
                        visited[newPos] = true;
                    }

                }
            }

        }

        return -1;


    }

    private int[] convertToIndex(int pos, int n) {
        int quot = (pos - 1) / n;
        int rem = (pos - 1) % n;
        int row = n - 1 - quot;
        int col = (quot % 2 == 0) ? rem : (n - 1 - rem);
        return new int[]{row, col};
    }

    //Also works
//    private int[] convertToIndex(int pos, int n) {
//        int r = pos / n, c = pos % n;
//
//        //Remainder non zero
//        if (c != 0) {
//            if (r % 2 == 0) {
//                return new int[]{n - r - 1, c - 1};
//            } else {
//                return new int[]{n - r - 1, n - c};
//            }
//        } else {
//            if (r % 2 == 0) {
//                return new int[]{n - r, 0};
//            } else {
//                return new int[]{n - r, n - 1};
//            }
//        }
//    }

    public static void main(String[] args) {

        int[][] board = {
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, 35, -1, -1, 13, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, 15, -1, -1, -1, -1}
        };

        Snakes_And_Ladders_909 obj = new Snakes_And_Ladders_909();

        int result = obj.snakesAndLadders(board);
        System.out.println("Minimum number of moves: " + result); // Expected: 4
    }
}
