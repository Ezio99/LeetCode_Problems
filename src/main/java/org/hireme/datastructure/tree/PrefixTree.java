package org.hireme.datastructure.tree;

import java.util.HashMap;

//Trie
public class PrefixTree {

    PrefixTreeNode rootNode;

    private static class PrefixTreeNode {
        /**
         * Could also be implemented as a character array if we know the number of distinct characters we can expect
         */
        HashMap<Character, PrefixTreeNode> children;
        /**
         * isWord carries 2 meanings
         * 1. The current character is the end of a valid word
         * 2. This word has been inserted into the tree
         * e.g. if we insert apple, we will also insert app, so if someone searches for word app we should return false
         * as that has not been inserted yet, even though it is an actual word
         */
        boolean isWord;

        private PrefixTreeNode() {
            this.children = new HashMap<>();
            isWord = false;
        }

        private boolean containsChild(Character ch) {
            return children.containsKey(ch);
        }

        public HashMap<Character, PrefixTreeNode> getChildren() {
            return children;
        }


        public boolean isWord() {
            return isWord;
        }

        public void setWord(boolean word) {
            isWord = word;
        }
    }


    public PrefixTree() {
        rootNode = new PrefixTreeNode();
    }

    public void insertWord(String word) {
        char ch;
        PrefixTreeNode currentNode = rootNode;
        for (int i = 0; i < word.length(); i++) {
            ch = word.charAt(i);
            if (!currentNode.containsChild(ch)) {
                currentNode.getChildren().put(ch, new PrefixTreeNode());
            }
            currentNode = currentNode.getChildren().get(ch);
        }
        currentNode.setWord(true);
    }

    public boolean searchWord(String word) {
        char ch;
        PrefixTreeNode currentNode = rootNode;
        for (int i = 0; i < word.length(); i++) {
            ch = word.charAt(i);
            if (!currentNode.containsChild(ch)) {
                return false;
            }
            currentNode = currentNode.getChildren().get(ch);
        }
        return currentNode.isWord;
    }

    public boolean startsWith(String prefix){
        char ch;
        PrefixTreeNode currentNode = rootNode;
        for (int i = 0; i < prefix.length(); i++) {
            ch = prefix.charAt(i);
            if (!currentNode.containsChild(ch)) {
                return false;
            }
            currentNode = currentNode.getChildren().get(ch);
        }
        return true;
    }


}
