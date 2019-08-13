package com.neu.learn;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ZigzagIterator {
	LinkedList<Iterator> list;
	
	//Constructor
	public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
		list = new LinkedList<Iterator>();
		if(!v1.isEmpty()) {
			list.add(v1.iterator());
		}
		if(!v2.isEmpty()) {
			list.add(v2.iterator());
		}
		//System.out.println("List is "+ list.toString());
	}
	
	public int next() {
		// Removing an element from the list...., Suppose you remove v1
		Iterator poll = list.remove();
		//result = next element of the removed Iterator
		int result = (Integer)poll.next();
		// if the removed iterator still has elements to process, add it back
		if(poll.hasNext()) {
			list.add(poll);
		}
		return result;
	}
	
	public boolean hasNext() {
		return !list.isEmpty();
	}

	public static void main(String[] args) {
		
		//V1 = [1,2,3], V2 = [4,5,6,7] Result :[1 4 2 5 3 6 7 ]
		
		List<Integer> v1 = new ArrayList<>();
		v1.add(1);
		v1.add(2);
		v1.add(3);
		
		List<Integer> v2 = new ArrayList<>();
		v2.add(4);
		v2.add(5);
		v2.add(6);
		v2.add(7);
		
		ZigzagIterator z1 = new ZigzagIterator(v1,v2);
		while(z1.hasNext()) {
			System.out.print(z1.next());
			System.out.print(" ");
		}
		return;
	}

}
