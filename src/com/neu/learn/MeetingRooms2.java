package com.neu.learn;
/* Leetcode #253 Meeting rooms 2
 * Problem Desc: Given an array of intervals bearing start and end
 * times, find the minimum number of conference rooms required*/

import java.util.Arrays;
import java.util.PriorityQueue;

/*Definition of an interval Object*/
class Interval{
	int start;
	int end;
	
	//Constructors
	Interval(){
		start = 0;
		end = 0;
	}
	Interval(int s, int e){
		start = s;
		end = e;
	}
}

public class MeetingRooms2 {
	public static int minMeetingRooms(Interval[] intervals) {
		 if(intervals == null || intervals.length == 0) {
			 return 0;
		 }
		 
		 //Sort meetings in asc.order of their start time
		 Arrays.sort(intervals, (a, b) -> a.start - b.start);
		 
		 // Create a minHeap storing the earliest end time of the meeting
		 PriorityQueue<Interval> minHeap = new PriorityQueue<>((a, b) -> a.end - b.end);
		 //Add the first meeting
		 minHeap.add(intervals[0]);
		 
		 for(int i = 1; i < intervals.length; i++) {
			 Interval current = intervals[i];
			 Interval earliest = minHeap.remove();
			 
			 //If your current meeting's start time is greater than
			 // your earliest meeting's end time, you don't need a meeting room
			 if(current.start >= earliest.end) {
				 earliest.end = current.end;
			 }else {
				 //Add the current meeting to the minHeap
				 minHeap.add(current);
			 }
			 // Now add again the removed interval back to the minHeap
			 minHeap.add(earliest);
		 }
		 //Finally with this, we shall have the all the meeting-rooms required
		 //simply by our minHeap size
		 return minHeap.size();
	}
	
	public static void main(String[] args) {
		Interval arr[]=new Interval[5]; 
        arr[0]=new Interval(2,15); 
        arr[1]=new Interval(36,45); 
        arr[2]=new Interval(9,29); 
        arr[3]=new Interval(16,23);
        arr[4]=new Interval(4,9);
        
        int numOfRooms = minMeetingRooms(arr);
        System.out.println(numOfRooms);
	}
}
