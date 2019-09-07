package com.neu.learn;

/*Leetcode #40 CombinationSum2: Given a collection of candidate 
 * numbers (candidates) and a target number (target), 
 * find all unique combinations in candidates where the 
 * candidate numbers sums to target.
 * 
 * */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {
	public static List<List<Integer>> combinationSum2(int[] candidates, int target){
		List<List<Integer>> result = new ArrayList<>();
		Arrays.sort(candidates);
		findCombinations(candidates, 0, target, new ArrayList<Integer>(), result);
		return result;
		
	}
	
	public static void findCombinations(int[] candidates, int index, int target, List<Integer> current, List<List<Integer>> result) {
		if(target == 0) {
			//Adding a copy of the current arrayList
			result.add(new ArrayList<>(current));
			return;
		}
		if(target < 0) {
			return;
		}
		
		// Simulating taking/ not taking of values
		for(int i = index; i < candidates.length; i++) {
			//Checking if it is the 1st num and for duplicates
			if(i == index || candidates[i] != candidates[i - 1]) {
				current.add(candidates[i]);
				//Simulating taking the number
				findCombinations(candidates, i + 1, target - candidates[i], current, result);
				//Simulating NOT taking the number
				current.remove(current.size() - 1);
			}
		}
		
	}
	public static void main(String[] args) {
		int[] candidates = {10, 1, 2, 7, 6, 1, 5};
		int target = 8;
		List<List<Integer>> result = combinationSum2(candidates, target);
		System.out.println(result);
	}

}
