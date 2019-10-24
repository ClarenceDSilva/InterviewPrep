package com.neu.learn;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/*Leetcode #239: Alien Dictionary*/
public class AlienDictionary_Leetcode {
	
	public static String alienOrder(String[] words) {
		if(words == null || words.length == 0) {
			return "";
		}
		
		Map<Character, Set<Character>> map = new HashMap<>();
		StringBuilder result = new StringBuilder();
		
		//Creating a graph out of the array of words(Adjacency List)
		for(String s : words) {
			for(char c : s.toCharArray()) {
				map.put(c, new HashSet<Character>());
			}
		}
		
		//Comparing each word by its previous word char by char
		// If different. Since c1 is before c2: Hence c1->c2
		for(int i = 0; i < words.length - 1; i++) {
			String curr = words[i]; 
			String next = words[i + 1];
			
			//Using the shorter word for iteration purposes
			int length = Math.min(curr.length(), next.length());
			
			for(int j = 0; j < length; j++) {
				char c1 = curr.charAt(j);   
				char c2 = next.charAt(j);
				if(c1 != c2) {
					//That is when you add it to your set
					Set<Character> set = map.get(c1);
					if(!set.contains(c2)) {
						set.add(c2);
						map.put(c1, set);
					}
					break;
				}
			}
		}
		
		// Topological sort via BFS
		Queue<Character> queue = new LinkedList<>();
		
		//Iterating over the graph and checking if the size of a particular set is 0
		// i.e. the node has no incoming edge, i.e. it has no dependency
		for(Map.Entry<Character, Set<Character>> entry: map.entrySet()) {
			if(entry.getValue().size() == 0) {
				// Add that node to the queue
				queue.offer(entry.getKey());
			}
		}
		while(!queue.isEmpty()) {
			char c = queue.poll();
			result.insert(0, c);
			
			// Iterating over the map and checking if any node matches with the node removed as key from the queue
			for(Map.Entry<Character, Set<Character>> entry: map.entrySet()) {
				if(entry.getValue().contains(c)) {
					entry.getValue().remove(c);
					if(entry.getValue().size() == 0) {
						queue.offer(entry.getKey());
					}
				}
			}
		}
		return result.toString();
	}
	public static void main(String[] args) {
		String[] words = {"wrt", "wrf", "er", "ett", "rftt"}; 
        String result = alienOrder(words);
        System.out.println(result);
	}

}
