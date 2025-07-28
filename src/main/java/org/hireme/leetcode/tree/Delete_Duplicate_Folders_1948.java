package org.hireme.leetcode.tree;

import java.util.*;

public class Delete_Duplicate_Folders_1948 {

    public class TrieNode {
        private TrieNode[] subFolders;
        String name;

        private TrieNode(String name) {
            this.name = name;
            subFolders = new TrieNode[26];
        }

        private boolean containsFolder(String folder) {
            return subFolders[folder.charAt(0) - 'a'] != null;
        }

        public TrieNode[] getSubFolders() {
            return subFolders;
        }

        public boolean isSubFolderEmpty() {
            for (TrieNode node : this.subFolders) {
                if (node != null) {
                    return false;
                }
            }

            return true;
        }
    }

    public class Trie {
        TrieNode root;

        public Trie(String name) {
            root = new TrieNode(name);
        }

        public void insertPath(List<String> path) {
            TrieNode currentNode = root;
            int val;
            for (String folder : path) {
                val = folder.charAt(0) - 'a';
                if (!currentNode.containsFolder(folder)) {
                    currentNode.getSubFolders()[val] = new TrieNode(folder);
                }
                currentNode = currentNode.getSubFolders()[val];
            }
        }
    }

    public List<List<String>> deleteDuplicateFolder(List<List<String>> paths) {

        Trie trie = new Trie("");
        //Construct trie
        for (List<String> path : paths) {
            trie.insertPath(path);
        }

        HashMap<String, List<TrieNode>> serializedFolders = new HashMap<>();
        dfs(trie.root, serializedFolders);

        return null;
    }

    public String dfs(TrieNode currentNode, HashMap<String, List<TrieNode>> serializedFolders) {

        StringBuilder serialized = new StringBuilder();
        TrieNode[] subfolders = currentNode.getSubFolders();
        for (int i = 0; i < 26; i++) {
            if (subfolders[i] != null) {
                if (subfolders[i].isSubFolderEmpty()) serialized.append(Character.toString(i + 97));
                else serialized.append(dfs(subfolders[i], serializedFolders));
            }
        }

        serializedFolders.computeIfAbsent(String.valueOf(serialized), k -> new ArrayList<>()).add(currentNode);


        return String.valueOf(serialized);
    }

    public static void main(String[] args) {
        Delete_Duplicate_Folders_1948 obj = new Delete_Duplicate_Folders_1948();
        List<List<String>> input = Arrays.asList(
                Arrays.asList("a"),
                Arrays.asList("c"),
                Arrays.asList("d"),
                Arrays.asList("a", "b"),
                Arrays.asList("c", "b"),
                Arrays.asList("d", "a")
        );
        System.out.println(obj.deleteDuplicateFolder(input));
    }


}
