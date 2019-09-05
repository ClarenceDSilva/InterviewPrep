package ds.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/*Leetcode #987: Given a binary tree, return the vertical order traversal of its nodes values.*/
public class VerticalOrderTraversal {
	
	public static List<List<Integer>> verticalTraversal(Node root){
		List<List<Integer>> result = new ArrayList<>();
		
		if(root == null) {
			return result;
		}
		// Map for storing column number and list of tree node values
		Map<Integer, List<Integer>> map = new HashMap<>();
		Queue<Node> queue = new LinkedList<>();
		Queue<Integer> cols = new LinkedList<>();
		
		// Adding the root to the queue and assigning it as cols 0
		queue.add(root);
		cols.add(0);
		
		//Adding a min and maximum to check from where the column begins 
		//and till where the column ends
		// I need max and min so that I know at the end where to start the traversal and where to end
		int min = 0;
		int max = 0;
		
		//BFS
		while(!queue.isEmpty()) {
			Node current = queue.poll();
			int col = cols.poll();
			
			// Add col to the map with new ArrayList
			if(!map.containsKey(col)) {
				map.put(col, new ArrayList<Integer>());
			}
			//Assign the nodes to that column
			map.get(col).add(current.data);
			// If current has a left child
			if(current.left != null) {
				queue.add(current.left);
				cols.add(col - 1);
				//Update min value
				min = Math.min(min, col - 1);
			}
			// if current has a right child
			if(current.right != null) {
				queue.add(current.right);
				cols.add(col + 1);
				//Updating the max value
				max = Math.max(max, col + 1);
			}
		}
		// Finally, we iterate over the min and max to print values
		for(int i = min; i <= max; i++) {
			result.add(map.get(i));
		}
		return result;
	}
	public static void main(String[] args) {
		
		/* Constructing below tree
		 
	        1
	      /   \
	     /     \
	    2       3
	   / \     /  \
	  /   \   /    \
	 4     5  6     7
	      
	    
	*/
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		
		List<List<Integer>> verticalOrders = verticalTraversal(root);
		System.out.println(verticalOrders);
	}

}
