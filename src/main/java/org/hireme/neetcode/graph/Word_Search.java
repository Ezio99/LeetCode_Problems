package org.hireme.neetcode.graph;

public class Word_Search {
    public boolean exist(char[][] board, String word) {
        int r = board.length, c = board[0].length;

        if (r * c < word.length()) {
            return false;
        }

        //Leetcode put a bunch of testcases with the beginning of the target but a letter missing
        // This avoids those
        word = new StringBuilder(word).reverse().toString();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (board[i][j] == word.charAt(0) && inplacedfs(i, j, board, word, 0)) {
                    return true;

                }
            }
        }

        return false;
    }

    public boolean inplacedfs(int i, int j, char[][] board, String word, int ctr) {
        if (ctr == word.length()) {
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return false;
        }


        char ch = word.charAt(ctr);
        boolean found = false;
        if (ch == board[i][j]) {
            //Avoids visit array by putting symbol which won't appear in word so even if we come here we wont use this pos
            board[i][j] = '#';
            found = inplacedfs(i + 1, j, board, word, ctr + 1) || inplacedfs(i - 1, j, board, word, ctr + 1)
                    || inplacedfs(i, j + 1, board, word, ctr + 1) || inplacedfs(i, j - 1, board, word, ctr + 1);
            board[i][j] = ch;
        }


        return found;
    }

    public boolean dfs(int i, int j, char[][] board, boolean[][] visit, String word, int ctr) {
        if (ctr == word.length()) {
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return false;
        }
        if (visit[i][j]) {
            return false;
        }

        visit[i][j] = true;
        char ch = word.charAt(ctr);
        boolean found = false;
        if (ch == board[i][j]) {
            found = dfs(i + 1, j, board, visit, word, ctr + 1) || dfs(i - 1, j, board, visit, word, ctr + 1)
                    || dfs(i, j + 1, board, visit, word, ctr + 1) || dfs(i, j - 1, board, visit, word, ctr + 1);
        }

        visit[i][j] = false;
        return found;
    }
}
