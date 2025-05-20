package org.hireme.neetcode.Trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;


public class WordSearch_2 {
    HashSet<String> resultSet = new HashSet<>();
    List<String> result = new ArrayList<>();

    public List<String> findWords(char[][] board, String[] words) {
        WordPrefixTree prefixTree = new WordPrefixTree();
        int numRows = board.length, numCols = board[0].length;
        boolean[][] visited;

        for (String word : words) {
            prefixTree.insert(word);
        }

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                visited = new boolean[numRows][numCols];
                dfs(i, j, prefixTree.root, board, visited);
            }
            if (resultSet.size() == words.length) {
                break;
            }
        }

        result.addAll(resultSet);


        return result;


    }

    private void dfs(int i, int j, WordPrefixTreeNode currentNode, char[][] board, boolean[][] visited) {
        if (currentNode.isWord()) {
            resultSet.add(currentNode.getWholeWord());
        }
        if (i < 0 || j < 0 || i > board.length - 1 || j > board[0].length - 1) {
            return;
        }
        if(visited[i][j]){
            return;
        }

        char ch = board[i][j];
        WordPrefixTreeNode child = currentNode.getChildren().get(ch);




        if (child != null) {
            visited[i][j] = true;
            dfs(i - 1, j, child, board, visited);
            dfs(i + 1, j, child, board, visited);
            dfs(i, j - 1, child, board, visited);
            dfs(i, j + 1, child, board, visited);
            visited[i][j] = false;
        }


    }

    public static void main(String[] args) {
        char[][] board = {
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}
        };

        String[] words = {"oath","pea","eat","rain","hklf","hf"};

//        char[][] board = {
//                {'a', 'b', 'c', 'd'},
//                {'s', 'a', 'a', 't'},
//                {'a', 'c', 'k', 'e'},
//                {'a', 'c', 'd', 'n'}
//        };
//
//        String[] words = {"bat", "cat", "back", "backend", "stack"};

        WordSearch_2 solver = new WordSearch_2();
        List<String> foundWords = solver.findWords(board, words);

        System.out.println("Words found:");
        for (String word : foundWords) {
            System.out.println(word);
        }
    }

    private static class WordPrefixTreeNode {
        private HashMap<Character, WordPrefixTreeNode> children;
        String wholeWord;
        private boolean isWord;

        public WordPrefixTreeNode() {
            children = new HashMap<>();
            isWord = false;
        }

        public HashMap<Character, WordPrefixTreeNode> getChildren() {
            return children;
        }

        public void setChildren(HashMap<Character, WordPrefixTreeNode> children) {
            this.children = children;
        }

        public boolean isWord() {
            return isWord;
        }

        public void setIsWord() {
            isWord = true;
        }

        public String getWholeWord() {
            return wholeWord;
        }

        public void setWholeWord(String wholeWord) {
            this.wholeWord = wholeWord;
        }
    }

    private static class WordPrefixTree {

        WordPrefixTreeNode root;

        public WordPrefixTree() {
            root = new WordPrefixTreeNode();
        }

        public void insert(String word) {
            WordPrefixTreeNode currentNode = root;
            for (int i = 0; i < word.length(); i++) {
                currentNode.getChildren().computeIfAbsent(word.charAt(i), k -> new WordPrefixTreeNode());
                currentNode = currentNode.getChildren().get(word.charAt(i));
            }
            currentNode.setIsWord();
            currentNode.setWholeWord(word);
        }

        public boolean search(String word) {
            WordPrefixTreeNode currentNode = root;
            for (int i = 0; i < word.length(); i++) {
                if (currentNode.getChildren().get(word.charAt(i)) == null) {
                    return false;
                }
                currentNode = currentNode.getChildren().get(word.charAt(i));
            }
            return currentNode.isWord();
        }

        public boolean startsWith(String prefix) {
            WordPrefixTreeNode currentNode = root;
            for (int i = 0; i < prefix.length(); i++) {
                if (currentNode.getChildren().get(prefix.charAt(i)) == null) {
                    return false;
                }
                currentNode = currentNode.getChildren().get(prefix.charAt(i));
            }
            return true;
        }

    }


}
