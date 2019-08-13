package com.neu.learn;
// Leetcode #207: Using BFS. Basically this also determines whether a graph has a cycle

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class CourseSchedule {
	public static boolean canFinish(int numCourses, int[][] prerequisites) {
		if(numCourses <= 1) {
			return true;
		}
		
		if(prerequisites.length == 0 || prerequisites[0].length == 0) {
			return false;
		}
		
		Map<Integer, Set<Integer>> graph = new HashMap<Integer, Set<Integer>>();
		
		// Building the graph
		//Number of nodes will be numCourses
		for(int i = 0; i < numCourses; i++) {
			graph.put(i, new HashSet<Integer>());
		}
		
		//Adding the Edges to the graph
		for(int i = 0; i < prerequisites.length; i++) {
			graph.get(prerequisites[i][0]).add(prerequisites[i][1]);
		}
		
		// BFS Code
		Queue<Integer> queue = new LinkedList<Integer>();
		int coursesRemaining = numCourses;
		
		//Iterating over the graph and checking if the size of a particular set is 0
		// i.e. the node has no incoming edge, i.e. it has no prerequisite
		for(Map.Entry<Integer, Set<Integer>> entry : graph.entrySet()) {
			if(entry.getValue().size() == 0) {
				// Add the course to the queue
				queue.offer(entry.getKey());
				coursesRemaining--;
			}
		}
		while(!queue.isEmpty()) {
			int key = queue.poll();
			
			// Iterating over the graph and checking if any prerequisite matches with the prerequisite removed as key from the queue 
			for(Map.Entry<Integer, Set<Integer>> entry : graph.entrySet()) {
				if(entry.getValue().contains(key)) {
					//Remove the course as prerequisite and checking that after removing does the set size become 0
					//In that case we can conclude that no other prerequisites are needed and we can go ahead and mark that course as completed
					entry.getValue().remove(key);
					if(entry.getValue().size() == 0) {
						// All prerequisites have been satisfied. You can complete the course now
						queue.offer(entry.getKey());
						coursesRemaining--;
					}
				}
			}
		}
		return coursesRemaining == 0;
	}
	
	public static void main(String[] args) {
		int[][] test1 = {{0, 1}, {1, 2}};
		System.out.println(canFinish(3, test1));
		
		int[][] test2 = {{0, 1}, {1, 0}};
		System.out.println(canFinish(2, test2));
	}

}
