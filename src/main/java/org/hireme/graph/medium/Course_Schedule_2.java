package org.hireme.graph.medium;

import java.util.*;

/*
    Topological sort : DFS
 */
public class Course_Schedule_2 {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        HashMap<Integer, ArrayList<Integer>> adjMatrix = new HashMap<>();
        int[] visited = new int[numCourses];
        int[] result = new int[numCourses];
        int x = numCourses-1,colour=1;

        for (int i = 0; i < prerequisites.length; i++) {
            adjMatrix.computeIfAbsent(prerequisites[i][1],k -> new ArrayList<>()).add(prerequisites[i][0]);
        }

        for (int i = 0; i < numCourses; i++) {
            if(visited[i]==0){
                boolean isCycle=false;
                List<Integer> visitedNodes = new ArrayList<>();
                isCycle = dfs(adjMatrix,visitedNodes,i,visited,colour,isCycle);
                colour++;
                if(isCycle){
                    return new int[0];
                }
                for (int j = 0; j < visitedNodes.size(); j++) {
                    result[x] = visitedNodes.get(j);
                    x--;
                }
            }

        }

        return result;




    }

    private boolean dfs(HashMap<Integer, ArrayList<Integer>> graph,List<Integer> visitedNodes,int currentNode,int[] visited,int colour,boolean isCycle){
        if(isCycle){
            return isCycle;
        }

        visited[currentNode] = colour;

        if(graph.get(currentNode)!=null){
            int nextNode;
            for (int i = 0; i < graph.get(currentNode).size(); i++) {
                 nextNode = graph.get(currentNode).get(i);
                 if(visited[nextNode]==0){
                     isCycle = dfs(graph,visitedNodes,nextNode,visited,colour,isCycle);
                 }
                 else if(visited[nextNode]==colour && !visitedNodes.contains(nextNode)){
                     //cycle
                     isCycle = true;
                     break;
                 }

            }
        }

        visitedNodes.add(currentNode);
        return isCycle;

    }

    public static void main(String[] args) {
        int numCourses = 4; // Number of courses
        int[][] prerequisites = {
                {1, 0},
                {2, 0},
                {3, 1},
                {3, 2}
        };

//        int numCourses = 2;
//        int[][] prerequisites = {{0,1},{1, 0}};

        System.out.println(Arrays.toString(new Course_Schedule_2().findOrder(numCourses, prerequisites)));
    }


}
