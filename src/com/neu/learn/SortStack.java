package com.neu.learn;

import java.util.ListIterator;
import java.util.Stack;

public class SortStack {
	
	// Method to sort stack
	public static void sortStack(Stack<Integer> stack) {
		if(!stack.isEmpty()) {
			//Remove the item
			int x = stack.pop();
			//Sort the remaining elements
			sortStack(stack);
			
			//Push the item back to the sorted stack
			sortedInsert(stack, x);	
		}
	}
	
	// Recursive Method to insert an item x in sorted way 
	public static void sortedInsert(Stack<Integer> stack, int x) {
		
		// Base case: Either stack is empty or newly inserted 
        // item is greater than top (more than all existing) 
		if(stack.isEmpty() || x > stack.peek()) {
			stack.push(x);
			return;
		}
		// If top is greater, remove the top item and recurse
		int temp = stack.pop();
		sortedInsert(stack, x);
		
		stack.push(temp);
	}
	
	// Utility Method to print contents of stack 
    static void printStack(Stack<Integer> s) 
    { 
       ListIterator<Integer> lt = s.listIterator(); 
         
       // forwarding 
       while(lt.hasNext()) 
           lt.next(); 
         
       // printing from top to bottom 
       while(lt.hasPrevious()) 
           System.out.print(lt.previous()+" "); 
    } 
    

	public static void main(String[] args) {
		Stack<Integer> s = new Stack<>(); 
        s.push(30); 
        s.push(-5); 
        s.push(18); 
        s.push(14); 
        s.push(-3); 
       
        System.out.println("Stack elements before sorting: "); 
        printStack(s); 
       
        sortStack(s); 
       
        System.out.println(" \n\nStack elements after sorting:"); 
        printStack(s); 

	}

}
