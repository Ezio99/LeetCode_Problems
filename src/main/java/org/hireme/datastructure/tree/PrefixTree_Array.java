package org.hireme.datastructure.tree;

//Trie
public class PrefixTree_Array {

    PrefixTreeNode rootNode;

    private static class PrefixTreeNode {
        PrefixTreeNode[] children;
        /**
         * isWord carries 2 meanings
         * 1. The current character is the end of a valid word
         * 2. This word has been inserted into the tree
         * e.g. if we insert apple, we will also insert app, so if someone searches for word app we should return false
         * as that has not been inserted yet, even though it is an actual word
         */
        boolean isWord;

        private PrefixTreeNode() {
            this.children = new PrefixTreeNode[26];
            isWord = false;
        }

        private boolean containsChild(int val) {
            return children[val] != null;
        }

        public PrefixTreeNode[] getChildren() {
            return children;
        }


        public boolean isWord() {
            return isWord;
        }

        public void setWord(boolean word) {
            isWord = word;
        }
    }


    public PrefixTree_Array() {
        rootNode = new PrefixTreeNode();
    }

    public void insertWord(String word) {
        char ch;
        int val;
        PrefixTreeNode currentNode = rootNode;
        for (int i = 0; i < word.length(); i++) {
            ch = word.charAt(i);
            val = ch - 97;
            if (!currentNode.containsChild(val)) {
                currentNode.getChildren()[val] = new PrefixTreeNode();
            }
            currentNode = currentNode.getChildren()[val];
        }
        currentNode.setWord(true);
    }

    public boolean searchWord(String word) {
        char ch;
        int val;
        PrefixTreeNode currentNode = rootNode;
        for (int i = 0; i < word.length(); i++) {
            ch = word.charAt(i);
            val = ch - 97;
            if (!currentNode.containsChild(val)) {
                return false;
            }
            currentNode = currentNode.getChildren()[val];
        }
        return currentNode.isWord;
    }

    public boolean startsWith(String prefix) {
        char ch;
        int val;
        PrefixTreeNode currentNode = rootNode;
        for (int i = 0; i < prefix.length(); i++) {
            ch = prefix.charAt(i);
            val = ch - 97;
            if (!currentNode.containsChild(val)) {
                return false;
            }
            currentNode = currentNode.getChildren()[val];
        }
        return true;
    }


}
