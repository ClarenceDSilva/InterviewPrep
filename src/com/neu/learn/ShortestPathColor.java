package com.neu.learn;
import java.util.*;

/* Uber Phone interview
*  Desc: You're given a directed graph with N nodes (labeled from 0 to N-1). Each edge is either Red or Blue in this graph.

    You are given N (number of nodes in graph) and two arrays redEdges and blueEdges where:
    redEdges[i] = [ai, bi] indicates that there is a directed red edge from node ai to node bi in the graph, and
    blueEdges[j] = [uj, vj] indicates that there is a directed blue edge from node uj to node vj in the graph.

    Return an array answer of length n, where each answer[x] is the length of the shortest path
    * from node 0 to node x such that the edge colors alternate along the path, or -1 if such a path does not exist.
* */
public class ShortestPathColor {
    static class Edge {
        public int source;
        public int dest;
        public String color;

        Edge(int source, int dest, String color){
            this.source = source;
            this.dest = dest;
            this.color = color;
        }
    }

    static class IntColorPair {
        public int node;
        public String color;
        public int level;

        public IntColorPair(int node, String color, int level) {
            this.node = node;
            this.color = color;
            this.level = level;
        }
    }
    public static int findShortest(Map<Integer, List<Edge>> graph, int source, int dest) {
        Set<Integer> visited = new HashSet<>();
        Queue<IntColorPair> bfsQueue = new LinkedList<>();
        bfsQueue.add(new IntColorPair(source, "Blue", 0));
        bfsQueue.add(new IntColorPair(source, "Red", 0));
        visited.add(source);

        int result = Integer.MAX_VALUE;

        while(!bfsQueue.isEmpty()) {
            for (int i = 0; i < bfsQueue.size(); i++) {

                IntColorPair currPair = bfsQueue.poll();
                int src = currPair.node;
                int currLevel = currPair.level;
                String color = currPair.color;
                if(src == dest) {
                    result = Math.min(result, currLevel);
                }else{
                    for(Edge e : graph.get(src)) {
                        if(!e.color.equals(color) && !visited.contains(e.dest)) {
                            visited.add(e.dest);
                            bfsQueue.add(new IntColorPair(e.dest, e.color, currLevel + 1));
                        }
                    }

                }
            }

        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("Welcome to the shortest path program!!");
        Map<Integer, List<Edge>> graph = new HashMap<>();
        graph.put(1, List.of(new Edge(1, 2, "Blue"), new Edge(1, 3, "Red"),  new Edge(1, 4, "Red")));
        graph.put(2, List.of(new Edge(2, 5, "Red"), new Edge(2, 6, "Blue")));
        graph.put(3, List.of(new Edge(3, 7, "Red"), new Edge(3, 8, "Blue"),  new Edge(3, 9, "Red")));
        graph.put(4, List.of(new Edge(4, 9, "Red")));
        graph.put(8, List.of(new Edge(8, 9, "Red")));
        graph.put(5, new ArrayList<>());
        graph.put(6, new ArrayList<>());
        graph.put(7, List.of(new Edge(7, 10, "Blue")));
        graph.put(9, List.of(new Edge(9, 10, "Blue")));
        graph.put(10, new ArrayList<>());
        int shortestPath = findShortest(graph, 1, 10);
        System.out.println(shortestPath);
    }
}
