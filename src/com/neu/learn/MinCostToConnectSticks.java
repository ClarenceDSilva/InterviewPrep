package com.neu.learn;

import java.util.PriorityQueue;

/*Leetcode #1167 
 *You have some sticks with positive integer lengths. You can connect any two sticks of lengths X and Y into one stick 
 *by paying a cost of X + Y.You perform this action until there is one stick remaining. Return the minimum cost of 
 *connecting all the given sticks into one stick in this way.
	Example 1:
	Input: sticks = [2,4,3]
	Output: 14
	
	Example 2:
	Input: sticks = [1,8,3,5]
	Output: 30
	
	Constraints:
	1 <= sticks.length <= 10^4
	1 <= sticks[i] <= 10^4
*/

public class MinCostToConnectSticks {
	
	public int connectSticks(int[] sticks) {
		int cost = 0;
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		for(int stick : sticks) {
			minHeap.add(stick);
		}
		
		while(minHeap.size() > 1) {
			int sum = minHeap.remove() + minHeap.remove();
			cost += sum;
			minHeap.add(sum);
		}
		
		return cost;
	}
	public static void main(String[] args) {
		MinCostToConnectSticks minCost = new MinCostToConnectSticks();
		
		int[] sticks1 = {2,4,3};
		System.out.println(minCost.connectSticks(sticks1));
		
		int[] sticks2 = {1,8,3,5};
		System.out.println(minCost.connectSticks(sticks2));
	}
}
