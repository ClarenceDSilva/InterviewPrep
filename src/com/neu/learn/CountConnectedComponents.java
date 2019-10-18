package com.neu.learn;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/*Leetcode #323: Number of Connected Components in an Undirected graph*/
public class CountConnectedComponents {
	
	public static int countComponents(int n, int[][] edges) {
		int result = 0;
		if(edges == null || edges.length == 0) {
			return result;
		}
		Stack<Integer> dfsStack = new Stack<Integer>();
		
		//Creating an array of visited nodes
		boolean[] visited = new boolean[n];
		
		//Creating adjacency list
		Map<Integer, Integer> map = new HashMap<>();
		
		for(int[] edge : edges) {
			map.put(edge[0], edge[1]);
		}
		
		//Performing DFS on the edges to find the connected components
		for(int i = 0; i < n; i++) {
			if(!visited[i]) {
				result++;
				dfsStack.push(i);
			}
				while(!dfsStack.isEmpty()) {
					int current = dfsStack.peek();
					dfsStack.pop();
					visited[current] = true;
					
					//Visit all its neighboring edges and add to the stack
					if(map.get(current) != null) {
						int neighbour = map.get(current);
						if(!visited[neighbour]) {
							dfsStack.push(neighbour);
						}
					}
				}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		int n = 5;
		int[][] edges = {{0, 1}, {1, 2}, {3, 4}};
		int result = countComponents(n, edges);
		System.out.println(result);
	}

}
