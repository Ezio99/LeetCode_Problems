package org.hireme.neetcode.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Course_Schedule_2 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] adjList = new List[numCourses];

        for (int[] courses : prerequisites) {
            if (adjList[courses[1]] == null) {
                adjList[courses[1]] = new ArrayList<>();
            }
            adjList[courses[1]].add(courses[0]);
        }

        List<Integer> ordering = new ArrayList<>();
        int[] result = new int[numCourses];
        boolean[] visited = new boolean[numCourses];
        boolean[] path = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (!visited[i] && recursiveHelper(i, ordering, visited, path, adjList)) {
                return new int[]{};
            }
        }

        for (int i = 0; i < numCourses; i++) {
            result[i] = ordering.get(numCourses - i - 1);
        }

        return result;
    }

    private boolean recursiveHelper(int currentNode, List<Integer> ordering, boolean[] visited, boolean[] path,
                                    List<Integer>[] adjList) {
        if (path[currentNode]) {
            return true;//Contains cycle
        }
        if (visited[currentNode]) {
            return false; //Just returning false as we know it does not have a cycle
        }

        visited[currentNode] = true;
        path[currentNode] = true;
        List<Integer> neighbours = adjList[currentNode];
        if (neighbours != null) {
            for (int neighbour : neighbours) {
                if (recursiveHelper(neighbour, ordering, visited, path, adjList)) {
                    return true;
                }
            }
        }
        path[currentNode] = false;
        ordering.add(currentNode);
        return false;

    }

    public static void main(String[] args) {
        Course_Schedule_2 obj = new Course_Schedule_2();
        System.out.println(Arrays.toString(obj.findOrder(3, new int[][]{{1, 0}})));
        System.out.println(Arrays.toString(obj.findOrder(3, new int[][]{
                {0, 1},
                {1, 2},
                {2, 0}
        })));
    }
}
