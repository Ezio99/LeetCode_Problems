//package org.hireme.neetcode.unionfind;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.HashSet;
//import java.util.List;
//
//public class Accounts_Merge_721 {
//
//    int[] parent;
//    int[] rank;
//
//    public List<List<String>> accountsMerge(List<List<String>> accounts) {
//        int numAccounts = accounts.size();
//        parent = new int[numAccounts];
//        rank = new int[numAccounts];
//        HashSet<String>[] emailsPerAccount = new HashSet[numAccounts];
//        HashMap<String, List<Integer>> commonNames = new HashMap<>();
//        for (int i = 0; i < numAccounts; i++) {
//            commonNames.computeIfAbsent(accounts.get(i).get(0), k -> new ArrayList<>()).add(i);
//            emailsPerAccount[i] = new HashSet<>(accounts.get(i).subList(1,accounts.get(i).size()-1));
//            parent[i] = i;
//            rank[i] = 0;
//        }
//
//        for (String name : commonNames.keySet()) {
//            for (int i = 0; i < commonNames.get(name).size(); i++) {
//
//            }
//        }
//    }
//}
