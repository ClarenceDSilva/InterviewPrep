package com.neu.learn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* Leetcode #56:Merge Intervals
 * Given a collection of intervals, merge all overlapping intervals.
 * */
public class MergeIntervals {
	public static int[][] merge(int[][] intervals){
		if(intervals == null || intervals.length == 0) {
			return intervals;
		}
		//Sorting the intervals based on their start time
		Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
		//Arrays.sort(intervals, (a,b) -> Integer.compare(a[0] - b[0]));
		List<int[]> result = new ArrayList<>();
		
		int[] start = intervals[0];
		result.add(start);
		for(int[] currInterval : intervals) {
			//You merge only when the end time of the start interval is greater than start time of the currInterval
			// Else you add it to the result array list
			
			if(currInterval[0] <= start[1]) {
				//Merge the interval
				start[1] = Math.max(start[1], currInterval[1]);
			}else {
				//Now make your currInterval as new start interval and add it to the array list
				start = currInterval;
				result.add(start);
			}
		}
		
		return result.toArray(new int[result.size()][2]);
	}

	/*Method with list datatype*/
	public static List<List<Integer>> mergeInt(List<List<Integer>> intervals){
		if(intervals == null || intervals.size() == 0) {
			return intervals;
		}
		//Sorting the intervals based on their start time
		Collections.sort(intervals, (a, b) -> a.get(0) - b.get(0));
		//Arrays.sort(intervals, (a,b) -> Integer.compare(a[0] - b[0]));
		List<List<Integer>> result = new ArrayList<>();

		List<Integer> start = intervals.get(0);
		result.add(start);
		for(List<Integer> currInterval : intervals) {
			//You merge only when the end time of the start interval is greater than start time of the currInterval
			// Else you add it to the result array list

			if(currInterval.get(0) <= start.get(1)) {
				//Merge the interval
				start.set(1, Math.max(start.get(1), currInterval.get(1)));
				//start.get(1) = Math.max(start.get(1), currInterval.get(1));
			}else {
				//Now make your currInterval as new start interval and add it to the array list
				start = currInterval;
				result.add(start);
			}
		}

		return result;
	}

	public static void main(String[] args) {
		List<List<Integer>> inter = Arrays.asList(new ArrayList<>(Arrays.asList(1,3)), new ArrayList<>(Arrays.asList(2,6)), new ArrayList<>(Arrays.asList(8,10)),new ArrayList<>(Arrays.asList(15,18)));
		int[][] intervals = {{1,3}, {2,6}, {8,10}, {15,18}};
		int [][] result = merge(intervals);
		List<List<Integer>> resList = mergeInt(inter);
		for(List<Integer> l : resList) {
			System.out.print(l + "->");
		}
//		for(int[] res : result)
//		System.out.println(res[0] + "," + res[1]);
	}

}
