package org.hireme.dynamicProblems.easy;

import java.util.ArrayList;
import java.util.List;


/*
    Union Find
    Will be faster with array instead of arraylist
 */
public class Find_If_Path_Exists_Graph {

    List<Integer> id = new ArrayList<>();
    List<Integer> size = new ArrayList<>();

    public boolean validPath(int n, int[][] edges, int source, int destination) {

        if (n < 1) {
            return false;
        }

        if(n==1){
            return true;
        }


        for (int i = 0; i < n; i++) {
            id.add(i);
               size.add(1);
        }

        for (int i = 0; i < edges.length; i++) {
            union(edges[i][0],edges[i][1]);

            if(isConnected(source,destination))
                return true;

        }

        return false;




    }


    private int findRoot(int x) {

        int root = x;
        while (id.get(root) != root) {
            root = id.get(root);
        }

        int q = x, next;
        while (id.get(q) != root) {
            next = id.get(q);
            id.set(q, root);
            q = next;
        }

        return root;

    }

    private boolean isConnected(int x, int y){
        return findRoot(x) == findRoot(y);
    }

    private void union(int x,int y){
        int rootX = findRoot(x);
        int rootY = findRoot(y);

        if(rootX == rootY)
            return;

        if(size.get(rootX) >= size.get(rootY)){
            id.set(rootY,rootX);
            size.set(rootX,size.get(rootX)+size.get(rootY));
        }
        else{
            id.set(rootX,rootY);
            size.set(rootY,size.get(rootX)+size.get(rootY));
        }
    }
}
