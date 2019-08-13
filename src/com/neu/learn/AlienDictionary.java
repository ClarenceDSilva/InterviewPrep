package com.neu.learn;

/*Leetcode Problem #269: Alien Dictionary
 * Using Topological Sort*/

import java.util.LinkedList;
import java.util.Stack;

// class to represent a Graph
class Graph{
	private final LinkedList<Integer>[] adjacencyList;
	
	Graph(int vertices){
		adjacencyList = new LinkedList[vertices];
		for(int vertexIndex = 0; vertexIndex < vertices; vertexIndex++) {
			// Initialize a linked list for every vertex
			adjacencyList[vertexIndex] = new LinkedList<Integer>();
		}
	}
	
	//Function to add an edge to the graph
	public void addEdge(int startVertex, int endVertex) {
		adjacencyList[startVertex].add(endVertex);
	}
	
	private int getNoOfVertices() {
		return adjacencyList.length;
	}
	
	// Recursive function used by Topological sort
	private void topologicalSortUtil(int currentVertex, boolean[] visited, Stack<Integer> stack) {
		// Mark the current node as visited
		visited[currentVertex] = true;
		
		//Recurse for all the vertices adjacent to this vertex
		for(int adjacentVertex: adjacencyList[currentVertex]) {
			if(!visited[adjacentVertex]) {
				topologicalSortUtil(adjacentVertex, visited, stack);
			}
		}
		//After all the adj vertices have been explored Push the current vertex
		stack.push(currentVertex);
	}
	
	// Prints the topological Sort of the complete graph
	public void topologicalSort() {
		// Initialize a stack and a visited array
		Stack<Integer> stack  = new Stack<Integer>();
		boolean[] visited = new boolean[getNoOfVertices()];
		
		//Recursively, call the Util function to sort and store all the vertices one by one
		for(int i = 0; i < getNoOfVertices(); i++) {
			if(!visited[i]) {
				// Call the Util method
				topologicalSortUtil(i, visited, stack);
			}
		}
		
		// Finally, when this is done, print all the contents of the stack
		while(!stack.isEmpty()) {
			System.out.println((char)('a' + stack.pop()) + " ");
		}
	}
}
public class AlienDictionary {
	private static void alienDictionary(String[] words) {
		Graph graph = new Graph(4);
		
		// Taking 2 words at a time and formulating edges between the graphs
		for(int i = 0; i < words.length - 1; i++ ) {
			String word1 = words[i];
			String word2 = words[i + 1];
			
			for(int j = 0; j < Math.min(word1.length(), word2.length());j++) {
				// If we find a mismatching character, we create an edge between them and add it to the graph
				//Then break the loop
				if(word1.charAt(j) != word2.charAt(j)) {
					graph.addEdge(word1.charAt(j) - 'a', word2.charAt(j) - 'a');
					break;
				}
			}
		}
		//Print the topological sort created by the graph
		graph.topologicalSort();
	}
	public static void main(String[] args) {
		String[] words = {"baa", "abcd", "abca", "cab", "cad"}; 
        alienDictionary(words); 	
	}

}
