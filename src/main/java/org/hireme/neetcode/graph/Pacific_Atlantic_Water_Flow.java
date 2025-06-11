package org.hireme.neetcode.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Pacific_Atlantic_Water_Flow {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int r = heights.length, c = heights[0].length;
        boolean[][] pacific = new boolean[r][c];
        boolean[][] atlantic = new boolean[r][c];
        for (int i = 0; i < c; i++) {
            dfs(0, i, heights, pacific, Integer.MIN_VALUE);
            dfs(r - 1, i, heights, atlantic, Integer.MIN_VALUE);
        }
        for (int i = 0; i < r; i++) {
            dfs(i, 0, heights, pacific, Integer.MIN_VALUE);
            dfs(i, c - 1, heights, atlantic, Integer.MIN_VALUE);
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }

        return result;

    }

    public void dfs(int i, int j, int[][] heights, boolean[][] ocean, int prevHeight) {
        if (i < 0 || i >= heights.length || j < 0 || j >= heights[0].length) {
            return;
        }
        if (ocean[i][j]) {
            return;
        }
        if (heights[i][j] < prevHeight) {
            return;
        }

        ocean[i][j] = true;
        dfs(i + 1, j, heights, ocean, heights[i][j]);
        dfs(i - 1, j, heights, ocean, heights[i][j]);
        dfs(i, j + 1, heights, ocean, heights[i][j]);
        dfs(i, j - 1, heights, ocean, heights[i][j]);
    }


}
