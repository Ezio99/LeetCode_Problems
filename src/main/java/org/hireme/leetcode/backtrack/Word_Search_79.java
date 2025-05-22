package org.hireme.leetcode.backtrack;

public class Word_Search_79 {
    public boolean exist(char[][] board, String word) {

        boolean[][] visited;

        word = new StringBuilder(word).reverse().toString();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (word.charAt(0) == board[i][j]) {
                    visited = new boolean[board.length][board[0].length];
                    if (dfsCheckExists(i, j, 0, word, board, visited)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean dfsCheckExists(int i, int j, int currentChar, String word, char[][] board, boolean[][] visit) {
        if (i < 0 || j < 0 || i > board.length - 1 || j > board[0].length - 1) {
            return false;
        }
        if (visit[i][j]) {
            return false;
        }
        if (board[i][j] != word.charAt(currentChar)) {
            return false;
        }
        if (currentChar == word.length() - 1) {
            return true;
        }

        visit[i][j] = true;

        boolean result = dfsCheckExists(i + 1, j, currentChar + 1, word, board, visit) ||
                dfsCheckExists(i - 1, j, currentChar + 1, word, board, visit) ||
                dfsCheckExists(i, j + 1, currentChar + 1, word, board, visit) ||
                dfsCheckExists(i, j - 1, currentChar + 1, word, board, visit);

        visit[i][j] = false;

        return result;
    }
}
