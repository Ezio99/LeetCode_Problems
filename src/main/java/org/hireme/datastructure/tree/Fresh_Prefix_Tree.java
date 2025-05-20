package org.hireme.datastructure.tree;

import java.util.HashMap;

public class Fresh_Prefix_Tree {

    private static class PrefixTreeNode {
        private HashMap<Character, PrefixTreeNode> children;
        private boolean isWord;

        public PrefixTreeNode(){
            children = new HashMap<>();
            isWord=false;
        }

        public HashMap<Character, PrefixTreeNode> getChildren() {
            return children;
        }

        public void setChildren(HashMap<Character, PrefixTreeNode> children) {
            this.children = children;
        }

        public boolean isWord() {
            return isWord;
        }

        public void setIsWord() {
            isWord = true;
        }
    }

    PrefixTreeNode root;

    public Fresh_Prefix_Tree() {
        root = new PrefixTreeNode();
    }

    public void insert(String word) {
        PrefixTreeNode currentNode = root;
        for (int i = 0; i < word.length(); i++) {
            currentNode.getChildren().computeIfAbsent(word.charAt(i), k -> new PrefixTreeNode());
            currentNode = currentNode.getChildren().get(word.charAt(i));
        }
        currentNode.setIsWord();
    }

    public boolean search(String word) {
        PrefixTreeNode currentNode = root;
        for (int i = 0; i < word.length(); i++) {
            if (currentNode.getChildren().get(word.charAt(i)) == null) {
                return false;
            }
            currentNode = currentNode.getChildren().get(word.charAt(i));
        }
        return currentNode.isWord();
    }

    public boolean startsWith(String prefix) {
        PrefixTreeNode currentNode = root;
        for (int i = 0; i < prefix.length(); i++) {
            if (currentNode.getChildren().get(prefix.charAt(i)) == null) {
                return false;
            }
            currentNode = currentNode.getChildren().get(prefix.charAt(i));
        }
        return true;
    }
}
