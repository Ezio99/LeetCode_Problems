package org.hireme.neetcode.graph;

import java.util.ArrayList;
import java.util.List;

public class Course_Schedule_4 {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        List<Integer>[] adjList = new List[numCourses];

        for (int[] courses : prerequisites) {
            if (adjList[courses[0]] == null) {
                adjList[courses[0]] = new ArrayList<>();
            }
            adjList[courses[0]].add(courses[1]);
        }

        boolean[][] nodesReachable = new boolean[numCourses][numCourses];
        boolean[] visited;

        for (int i = 0; i < numCourses; i++) {
            visited = new boolean[numCourses];
            recursiveHelper(i, visited, adjList);
            nodesReachable[i] = visited;
        }

        List<Boolean> result = new ArrayList<>();

        for (int[] query : queries) {
            result.add(nodesReachable[query[0]][query[1]]);
        }


        return result;
    }

    private boolean recursiveHelper(int currentNode, boolean[] visited, List<Integer>[] adjList) {
        if (visited[currentNode]) {
            return false;
        }

        visited[currentNode] = true;
        List<Integer> neighbours = adjList[currentNode];
        if (neighbours != null) {
            for (int neighbour : neighbours) {
                if (recursiveHelper(neighbour, visited, adjList)) {
                    return true;
                }
            }
        }
        return false;

    }

    public static void main(String[] args) {
        Course_Schedule_4 obj = new Course_Schedule_4();
        System.out.println(obj.checkIfPrerequisite(2, new int[][]{{1, 0}}, new int[][]{
                {0, 1},
                {1, 0}
        }));

        System.out.println(obj.checkIfPrerequisite(2, new int[][]{}, new int[][]{
                {0, 1},
                {1, 0}
        }));


        System.out.println(obj.checkIfPrerequisite(3, new int[][]{
                {1, 2},
                {1, 0},
                {2, 0}
        }, new int[][]{
                {1, 0},
                {1, 2}
        }));

    }
}
