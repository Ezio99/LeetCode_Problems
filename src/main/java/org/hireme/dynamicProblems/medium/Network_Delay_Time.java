package org.hireme.dynamicProblems.medium;


import java.util.*;

/*
Dijkstra

Store the edges actually getting used in a hashmap with node as key, and keep max of each node
if vis has any false remaining -1
 */
public class Network_Delay_Time {

    static class Graph {

        static class Node {
            int vertex;
            int cost;

            public Node(int vertex, int cost) {
                this.vertex = vertex;
                this.cost = cost;
            }

            public int compareTo(Node otherNode) {
                return Integer.compare(this.cost, otherNode.cost);
            }
        }

        HashMap<Integer, List<Node>> graph;
        int n;

        public Graph(int n) {
            graph = new HashMap<>();
            this.n = n;
        }

        public void addEdge(int u, int v, int w) {
            graph.computeIfAbsent(u, k -> new ArrayList<>()).add(new Node(v, w));
            //Add to destination if bidirectional
        }

        public int dijkstra(int source) {
            int[] dist = new int[n];
            boolean[] visited = new boolean[n];
            int[] prev = new int[n];

            Arrays.fill(dist, Integer.MAX_VALUE);

            dist[source] = 0;

            PriorityQueue<Node> priorityQueue = new PriorityQueue<>(new Comparator<Node>() {
                @Override
                public int compare(Node o1, Node o2) {
                    return o1.compareTo(o2);
                }
            });

            //Starting from source so cost 0
            priorityQueue.add(new Node(source, 0));

            int t = 0;

            while (!priorityQueue.isEmpty()) {
                Node currentNode = priorityQueue.poll();
                visited[currentNode.vertex] = true;

                if (dist[currentNode.vertex] < currentNode.cost) {
                    continue;
                }

                if (graph.get(currentNode.vertex) == null) {
                    continue;
                }

//                t=Math.max(t,dist[currentNode.vertex]);

                for (Node neigbhour : graph.get(currentNode.vertex)) {
                    if (visited[neigbhour.vertex]) {
                        continue;
                    }
                    int newDist = dist[currentNode.vertex] + neigbhour.cost;
                    if (newDist < dist[neigbhour.vertex]) {
                        prev[neigbhour.vertex] = currentNode.vertex;
                        dist[neigbhour.vertex] = newDist;
                        priorityQueue.add(new Node(neigbhour.vertex, newDist));
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    return -1;
                }
            }

            int maxn=-1;
            for (int i = 0; i < n; i++) {
                if(dist[i]>maxn){
                    maxn = dist[i];
                }
            }

            return maxn;
        }

    }


    public static int networkDelayTime(int[][] times, int n, int k) {
        Graph graph = new Graph(n);
        for (int i = 0; i < times.length; i++) {
            graph.addEdge(times[i][0] - 1, times[i][1] - 1, times[i][2]);
        }
        return graph.dijkstra(k - 1);
    }

    public static void main(String[] args) {
//        int[][] times = {
//                {2, 1, 1},
//                {2, 3, 1},
//                {3, 4, 1}
//        };
//        int n = 4;
//        int k = 2;

        int[][] times = {
                {3, 5, 78},
                {2, 1, 1},
                {1, 3, 0},
                {4, 3, 59},
                {5, 3, 85},
                {5, 2, 22},
                {2, 4, 23},
                {1, 4, 43},
                {4, 5, 75},
                {5, 1, 15},
                {1, 5, 91},
                {4, 1, 16},
                {3, 2, 98},
                {3, 4, 22},
                {5, 4, 31},
                {1, 2, 0},
                {2, 5, 4},
                {4, 2, 51},
                {3, 1, 36},
                {2, 3, 59}
        };
        int n = 5;
        int k = 5;


        System.out.println(networkDelayTime(times, n, k));
    }
}
