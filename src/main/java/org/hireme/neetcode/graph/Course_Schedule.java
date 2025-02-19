package org.hireme.neetcode.graph;

import java.util.ArrayList;
import java.util.List;

//
public class Course_Schedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] adjacencyList = new List[numCourses];

        for (int i = 0; i < numCourses; i++) {
            adjacencyList[i] = new ArrayList<>(); // Only needed for other option
        }

        for (int[] condition : prerequisites) {
            if (adjacencyList[condition[1]] == null) {
                adjacencyList[condition[1]] = new ArrayList<>();
            }
            adjacencyList[condition[1]].add(condition[0]);
        }

        boolean[] visit = new boolean[numCourses];
        boolean[] path = new boolean[numCourses];
//        int[] ordering = new int[numCourses];
        int ctr = 0;
        for (int i = 0; i < numCourses; i++) {
            ctr++;
            if (!visit[i] && hasCycle(i, adjacencyList, visit, path)) {//not visited
                return false;
            }
        }

        return true;

    }

    private boolean recursiveHelper(int i, boolean[] visit, List<Integer>[] adjacencyList, boolean[] path) {
        if (path[i]) {
            return true;
        }

        boolean result = false;
        visit[i] = true;
        path[i] = true;
        List<Integer> neighbours = adjacencyList[i] == null ? new ArrayList<>() : adjacencyList[i];
        for (int neighbour : neighbours) {
            if (path[neighbour]) {
                return true;
            }
            if (!visit[neighbour]) {
                result = recursiveHelper(neighbour, visit, adjacencyList, path);
                if (result) {
                    return result;
                }
            }
        }
        path[i] = false;

        return result;

    }

    //Another option
    private boolean hasCycle(int node, List<Integer>[] adjacencyList, boolean[] visit, boolean[] path) {
        if (path[node]) return true; // Cycle detected
        if (visit[node]) return false; // Node already processed, no cycle

        path[node] = true; // Mark node in current DFS path
        for (int neighbor : adjacencyList[node]) { // ✅ Safe since lists are always initialized
            if (hasCycle(neighbor, adjacencyList, visit, path)) {
                return true;
            }
        }
        path[node] = false; // Backtrack
        visit[node] = true;  // Mark node as fully processed
        return false;
    }

    public static void main(String[] args) {
        Course_Schedule obj = new Course_Schedule();
        System.out.println(obj.canFinish(3, new int[][]{
                {1, 0},
                {2, 0},
                {0, 1},
        }));
    }


}
