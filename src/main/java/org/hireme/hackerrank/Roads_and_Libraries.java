package org.hireme.hackerrank;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/*
    Union Find
    Clump together cities which can be connected, min no. of roads that can be built in a component to connect them all is n-1
 */

public class Roads_and_Libraries {

    static int[] cityNodes;
    static int[] size;
    static int numberOfComponents = 0;

    public static long roadsAndLibraries(int n, int c_lib, int c_road, List<List<Integer>> cities) {

        //Best scenario for building roads is when only 1 component is there so we need to build just 1 lib
        // which is connected to all others by road
//        if (c_lib * n < (c_road * (n - 1)) + c_lib) {
//            return (long) c_lib * n;
//        }

        if (c_road>= c_lib) {
            return (long) c_lib * n;
        }

        // Write your code here
        cityNodes = new int[n + 1];
        size = new int[n + 1];
        numberOfComponents = n;

        //Construct array for UF
        for (int i = 1; i < n + 1; i++) {
            cityNodes[i] = i;
            size[i] = 1;
        }

        for (List<Integer> cityConnection : cities) {
            union(cityConnection.get(0), cityConnection.get(1));
        }

        int i = 1;
        long totalCost = 0L, costOfOnlyLib, regularCost;

        while (numberOfComponents > 0) {
            if (size[i] != 0) {
                costOfOnlyLib = (long) size[i] * c_lib;
                regularCost = ((long) (size[i] - 1) * c_road) + c_lib;
                totalCost += Math.min(costOfOnlyLib, regularCost);
                numberOfComponents--;
            }
            i++;
        }

        System.out.println(totalCost);
        return totalCost;


    }

    private static int findRoot(int k) {
        int root = k;
        while (cityNodes[root] != root) {
            root = cityNodes[root];
        }

        int next, current = k;
        while (cityNodes[current] != root) {
            next = cityNodes[current];
            cityNodes[current] = root;
            current = next;
        }

        return root;
    }

//    private static boolean isConnected(int x, int y) {
//        return findRoot(x) == findRoot(y);
//    }

    private static void union(int x, int y) {
        int rootX = findRoot(x);
        int rootY = findRoot(y);

        if (rootX == rootY) return;

        if (size[rootX] >= size[rootY]) {
            cityNodes[rootY] = rootX;
            size[rootX] += size[rootY];
            size[rootY] = 0;
        } else {
            cityNodes[rootX] = rootY;
            size[rootY] += size[rootX];
            size[rootX] = 0;
        }

        numberOfComponents--;


    }


//    public static void main(String[] args) {
//        int numCities = 6; // Number of cities
//        int numRoads = 6;  // Number of roads
//        int libCost = 2;   // Cost of building a library
//        int roadCost = 1;  // Cost of repairing a road
//
//        List<List<Integer>> roads = new ArrayList<>();
//
//        // Initialize the roads as a list of city connections
//        List<Integer> road1 = new ArrayList<>();
//        road1.add(1);
//        road1.add(3);
//        roads.add(road1);
//
//        List<Integer> road2 = new ArrayList<>();
//        road2.add(3);
//        road2.add(4);
//        roads.add(road2);
//
//        List<Integer> road3 = new ArrayList<>();
//        road3.add(2);
//        road3.add(4);
//        roads.add(road3);
//
//        List<Integer> road4 = new ArrayList<>();
//        road4.add(1);
//        road4.add(2);
//        roads.add(road4);
//
//        List<Integer> road5 = new ArrayList<>();
//        road5.add(2);
//        road5.add(3);
//        roads.add(road5);
//
//        List<Integer> road6 = new ArrayList<>();
//        road6.add(5);
//        road6.add(6);
//        roads.add(road6);
//
//        long totalCost = roadsAndLibraries(numCities, libCost, roadCost, roads);
//
//        // Print the total minimum cost
//        System.out.println(totalCost);
//    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int n = Integer.parseInt(firstMultipleInput[0]);

                int m = Integer.parseInt(firstMultipleInput[1]);

                int c_lib = Integer.parseInt(firstMultipleInput[2]);

                int c_road = Integer.parseInt(firstMultipleInput[3]);

                List<List<Integer>> cities = new ArrayList<>();

                IntStream.range(0, m).forEach(i -> {
                    try {
                        cities.add(
                                Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                        .map(Integer::parseInt)
                                        .collect(toList())
                        );
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });

                long result = roadsAndLibraries(n, c_lib, c_road, cities);

                System.out.println("Final result - "+result);

//                bufferedWriter.write(String.valueOf(result));
//                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
//        bufferedWriter.close();
    }

}
