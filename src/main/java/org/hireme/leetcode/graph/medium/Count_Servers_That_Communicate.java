package org.hireme.leetcode.graph.medium;

import java.util.Comparator;
import java.util.PriorityQueue;


/*
Union Find
Graph can be represented as adjacency list -> (node1->n2,n3  n2->n4...), 2d array,
 */
public class Count_Servers_That_Communicate {

    static int numberOfComponents = 0;

    static int[] id;

    static int[] size;



    public static int countServers(int[][] grid) {

        int numberOfElements = grid[0].length, numberOfArrays = grid.length;

        id = new int[numberOfArrays * numberOfElements];
        size = new int[numberOfArrays * numberOfElements];

        int[] vertical = new int[numberOfElements];

        for (int i = 0; i < numberOfArrays; i++) {
            for (int j = 0; j < numberOfElements; j++) {
                if (grid[i][j] == 1) {
                    numberOfComponents++;
                    // Index(array number) - starting point + offset
                    id[i * numberOfElements + j % numberOfElements] = i * numberOfElements + j % numberOfElements;
                    size[i * numberOfElements + j % numberOfElements] = 1;
                } else {
                    id[i * numberOfElements + j % numberOfElements] = -1;
                    size[i * numberOfElements + j % numberOfElements] = 0;
                }
                vertical[j] = -1;
            }
        }


        for (int i = 0; i < numberOfArrays; i++) {
            int ctr = 0;
            int x=i, y=0;
            for (int j = 0; j < numberOfElements; j++) {
                if (grid[i][j] == 1) {
                    ctr++;

                    if (ctr == 1) {
                        x = i;
                        y = j;
                    }
                    else {
                        //Union with the one that came before
                        union(x*numberOfElements+y%numberOfElements,i*numberOfElements+j%numberOfElements);
                    }

                    if(vertical[j]==-1){
                        vertical[j] = i*numberOfElements+j%numberOfElements;
                    }
                    else{
                        union(vertical[j],i*numberOfElements+j%numberOfElements);
                    }

//                    if(vertical[j]==0){
//                        for (int k = i+1; k < numberOfArrays; k++) {
//                            if(grid[k][j]==1){
//                                union(i*numberOfElements+j%numberOfElements,k*numberOfElements+j%numberOfElements);
//                            }
//                        }
//                        vertical[j] = 1;
//                    }
                }
            }
        }

        int sum = 0;

        for (int i = 0; i < numberOfElements; i++) {
            if (vertical[i]>=0 && size[vertical[i]] > 1) {
                sum += size[vertical[i]];
            }
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        pq.poll();

        return sum;


    }


    public static int findRoot(int x) {
        int root = x;
        while (id[root] != root) {
            root = id[root];
        }

        int next, current = x;
        while (id[current] != root) {
            next = id[current];
            id[current] = root;
            current = next;
        }
        return root;
    }

    private static boolean isConnected(int x, int y) {
        return findRoot(x) == findRoot(y);
    }

    private static void union(int x, int y) {
        int rootX = findRoot(x);
        int rootY = findRoot(y);

        if (rootX == rootY)
            return;


        if (size[rootX] >= size[rootY]) {
            id[rootY] = rootX;
            size[rootX] += size[rootY];
            size[rootY] = 0;
        } else {
            id[rootX] = rootY;
            size[rootY] += size[rootX];
            size[rootX] = 0;
        }

        numberOfComponents--;
    }

    public static void main(String[] args) {


//        int[][] grid = {
//                {1, 0, 0, 1, 0},
//                {0, 1, 0, 0, 0},
//                {0, 0, 1, 0, 0},
//                {1, 0, 0, 1, 1},
//                {0, 0, 0, 0, 1}
//        };

//        int[][] grid = {
//                {1, 0},
//                {1, 1,},
//        };

        int[][] grid = {
                {1, 1, 0, 0},
                {0, 0, 1, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 1}
        };

        System.out.println(countServers(grid));
    }


}
