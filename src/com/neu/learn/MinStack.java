package com.neu.learn;

/*Leetcode Problem #155
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.*/

class Node {
	int data;
	int min;
	Node next;
	
	// Initializing a node
	public Node(int data, int min) {
		this.data = data;
		this.min = min;
		this.next = null;
	}
}

public class MinStack {
	Node head;
	
	/** initialize your data structure here. */
	public MinStack() {
		
	}
	
	public void push(int x) {
		//If no linked list has been created, create a new linked list
		if(head == null) {
			head = new Node(x,x);
		}else {
			// Since it is a stack, we will always insert at the beginning
			Node newNode = new Node(x, Math.min(x,head.min));
			newNode.next = head;
			head = newNode;
		}
	}
	
	public void pop() {
		head = head.next;
	}
	
	public int top() {
		return head.data;
	}
	
	public int getMin() {
		return head.min;
	}
	
}

