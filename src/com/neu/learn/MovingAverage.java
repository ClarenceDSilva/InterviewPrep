package com.neu.learn;

import java.util.LinkedList;
import java.util.Queue;

/*LeetCode problem #346*/
public class MovingAverage {
	private Queue<Integer> queue;
	private int maxSize;
	private double sum;
	
	public MovingAverage(int size) {
		queue = new LinkedList<Integer>();
		maxSize = size;
		sum = 0.0; 
	}
	
	public double next(int val) {
		if(queue.size() == maxSize) {
			// When queue if full, remove the 1st element and update the sum
			sum -= queue.remove();
		}
		queue.add(val);
		sum += val;
		return sum / queue.size();
	}
	public static void main(String[] args) {
		MovingAverage mv = new MovingAverage(3);
		mv.next(1);
		mv.next(5);
		mv.next(2);
		double result = mv.next(7);
		System.out.println("After adding 7: "+ result);
		
		
	}

}
